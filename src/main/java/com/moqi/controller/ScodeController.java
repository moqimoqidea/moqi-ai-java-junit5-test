package com.moqi.controller;

import com.moqi.dto.ScodeDTO;
import com.moqi.service.ScodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scodes")
public class ScodeController {
    private final ScodeService scodeService;

    public ScodeController(ScodeService scodeService) {
        this.scodeService = scodeService;
    }

    @PostMapping("/query")
    public ResponseEntity<List<ScodeDTO>> queryScodes(@RequestBody(required = false) ScodeDTO criteria) {
        List<ScodeDTO> scodes = scodeService.getAllScodes();
        return ResponseEntity.ok(scodes);
    }

    @PostMapping
    public ResponseEntity<ScodeDTO> createScode(@RequestBody ScodeDTO scodeDTO) {
        ScodeDTO created = scodeService.createScode(scodeDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScodeDTO> getScode(@PathVariable Long id) {
        return scodeService.getScodeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScodeDTO> updateScode(@PathVariable Long id, @RequestBody ScodeDTO scodeDTO) {
        return scodeService.updateScode(id, scodeDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScode(@PathVariable Long id) {
        scodeService.deleteScode(id);
        return ResponseEntity.ok().build();
    }
} 