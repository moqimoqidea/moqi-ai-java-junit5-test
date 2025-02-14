package com.moqi.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private Integer age;
    private String grade;
    private Long schoolId;
    private Long createdAt;
    private Long updatedAt;
} 