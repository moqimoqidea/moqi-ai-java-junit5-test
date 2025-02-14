package com.moqi.service;

import com.moqi.dto.ScodeDTO;
import com.moqi.model.Scode;
import com.moqi.repository.SchoolRepository;
import com.moqi.repository.ScodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScodeService {
    private final ScodeRepository scodeRepository;
    private final SchoolRepository schoolRepository;

    public ScodeService(ScodeRepository scodeRepository, SchoolRepository schoolRepository) {
        this.scodeRepository = scodeRepository;
        this.schoolRepository = schoolRepository;
    }

    @Transactional
    public ScodeDTO createScode(ScodeDTO scodeDTO) {
        Scode scode = new Scode();
        copyToEntity(scodeDTO, scode);
        scode.setCreatedAt(System.currentTimeMillis());
        scode.setUpdatedAt(System.currentTimeMillis());
        scode = scodeRepository.save(scode);
        copyToDTO(scode, scodeDTO);
        return scodeDTO;
    }

    @Transactional(readOnly = true)
    public List<ScodeDTO> getAllScodes() {
        return scodeRepository.findAll().stream()
                .map(scode -> {
                    ScodeDTO dto = new ScodeDTO();
                    copyToDTO(scode, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ScodeDTO> getScodeById(Long id) {
        return scodeRepository.findById(id)
                .map(scode -> {
                    ScodeDTO dto = new ScodeDTO();
                    copyToDTO(scode, dto);
                    return dto;
                });
    }

    @Transactional
    public Optional<ScodeDTO> updateScode(Long id, ScodeDTO scodeDTO) {
        return scodeRepository.findById(id)
                .map(scode -> {
                    copyToEntity(scodeDTO, scode);
                    scode.setId(id);
                    scode.setUpdatedAt(System.currentTimeMillis());
                    scode = scodeRepository.save(scode);
                    copyToDTO(scode, scodeDTO);
                    return scodeDTO;
                });
    }

    @Transactional
    public void deleteScode(Long id) {
        scodeRepository.deleteById(id);
    }

    private void copyToEntity(ScodeDTO dto, Scode entity) {
        BeanUtils.copyProperties(dto, entity, "id", "schoolId");
        if (dto.getSchoolId() != null) {
            schoolRepository.findById(dto.getSchoolId())
                    .ifPresent(entity::setSchool);
        }
    }

    private void copyToDTO(Scode entity, ScodeDTO dto) {
        BeanUtils.copyProperties(entity, dto, "school");
        if (entity.getSchool() != null) {
            dto.setSchoolId(entity.getSchool().getId());
        }
    }
} 