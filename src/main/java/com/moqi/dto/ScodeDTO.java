package com.moqi.dto;

import lombok.Data;

@Data
public class ScodeDTO {
    private Long id;
    private String code;
    private Long schoolId;
    private String description;
    private Long createdAt;
    private Long updatedAt;
} 