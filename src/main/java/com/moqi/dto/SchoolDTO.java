package com.moqi.dto;

import lombok.Data;

@Data
public class SchoolDTO {
    private Long id;
    private String name;
    private String address;
    private String description;
    private Long createdAt;
    private Long updatedAt;
} 