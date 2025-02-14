package com.moqi.service;

import com.moqi.dto.StudentDTO;
import com.moqi.model.Student;
import com.moqi.repository.SchoolRepository;
import com.moqi.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        copyToEntity(studentDTO, student);
        student.setCreatedAt(System.currentTimeMillis());
        student.setUpdatedAt(System.currentTimeMillis());
        student = studentRepository.save(student);
        copyToDTO(student, studentDTO);
        return studentDTO;
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> {
                    StudentDTO dto = new StudentDTO();
                    copyToDTO(student, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<StudentDTO> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    StudentDTO dto = new StudentDTO();
                    copyToDTO(student, dto);
                    return dto;
                });
    }

    @Transactional
    public Optional<StudentDTO> updateStudent(Long id, StudentDTO studentDTO) {
        return studentRepository.findById(id)
                .map(student -> {
                    copyToEntity(studentDTO, student);
                    student.setId(id);
                    student.setUpdatedAt(System.currentTimeMillis());
                    student = studentRepository.save(student);
                    copyToDTO(student, studentDTO);
                    return studentDTO;
                });
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private void copyToEntity(StudentDTO dto, Student entity) {
        BeanUtils.copyProperties(dto, entity, "id", "schoolId");
        if (dto.getSchoolId() != null) {
            schoolRepository.findById(dto.getSchoolId())
                    .ifPresent(entity::setSchool);
        }
    }

    private void copyToDTO(Student entity, StudentDTO dto) {
        BeanUtils.copyProperties(entity, dto, "school");
        if (entity.getSchool() != null) {
            dto.setSchoolId(entity.getSchool().getId());
        }
    }
} 