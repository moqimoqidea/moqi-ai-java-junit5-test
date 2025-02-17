package com.moqi.controller;

import com.moqi.dto.SchoolDTO;
import com.moqi.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/query")
    public ResponseEntity<List<SchoolDTO>> querySchools(@RequestBody SchoolDTO criteria) {
        // For now, we'll return all schools regardless of criteria
        // You can extend this to implement filtering based on criteria
        List<SchoolDTO> schools = schoolService.getAllSchools();
        return ResponseEntity.ok(schools);
    }

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> queryHello(@RequestBody SchoolDTO criteria) {
        return ResponseEntity.ok(Map.of("hello", "world"));
    }

    @PostMapping
    public ResponseEntity<SchoolDTO> createSchool(@RequestBody SchoolDTO schoolDTO) {
        SchoolDTO created = schoolService.createSchool(schoolDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolDTO> getSchool(@PathVariable Long id) {
        return schoolService.getSchoolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolDTO> updateSchool(@PathVariable Long id, @RequestBody SchoolDTO schoolDTO) {
        return schoolService.updateSchool(id, schoolDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.ok().build();
    }
} 
