package com.moqi.service;

import com.moqi.dto.SchoolDTO;
import com.moqi.model.School;
import com.moqi.repository.SchoolRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Transactional
    public SchoolDTO createSchool(SchoolDTO schoolDTO) {
        School school = new School();
        BeanUtils.copyProperties(schoolDTO, school);
        school.setCreatedAt(System.currentTimeMillis());
        school.setUpdatedAt(System.currentTimeMillis());
        school = schoolRepository.save(school);
        BeanUtils.copyProperties(school, schoolDTO);
        return schoolDTO;
    }

    @Transactional(readOnly = true)
    public List<SchoolDTO> getAllSchools() {
        return schoolRepository.findAll().stream()
                .map(school -> {
                    SchoolDTO dto = new SchoolDTO();
                    BeanUtils.copyProperties(school, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<SchoolDTO> getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .map(school -> {
                    SchoolDTO dto = new SchoolDTO();
                    BeanUtils.copyProperties(school, dto);
                    return dto;
                });
    }

    @Transactional
    public Optional<SchoolDTO> updateSchool(Long id, SchoolDTO schoolDTO) {
        return schoolRepository.findById(id)
                .map(school -> {
                    BeanUtils.copyProperties(schoolDTO, school);
                    school.setId(id);
                    school.setUpdatedAt(System.currentTimeMillis());
                    school = schoolRepository.save(school);
                    BeanUtils.copyProperties(school, schoolDTO);
                    return schoolDTO;
                });
    }

    @Transactional
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
} 