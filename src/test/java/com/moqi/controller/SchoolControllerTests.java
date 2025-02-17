package com.moqi.controller;

import com.moqi.dto.SchoolDTO;
import com.moqi.service.SchoolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SchoolControllerTests {

    @Mock
    private SchoolService schoolService;

    @InjectMocks
    private SchoolController schoolController;

    private SchoolDTO schoolDTO;

    @BeforeEach
    void setUp() {
        schoolDTO = new SchoolDTO();
        schoolDTO.setId(1L);
        schoolDTO.setName("Test School");
    }

    @Test
    void querySchools_ShouldReturnAllSchools() {
        List<SchoolDTO> schools = Arrays.asList(schoolDTO);
        when(schoolService.getAllSchools()).thenReturn(schools);

        ResponseEntity<List<SchoolDTO>> response = schoolController.querySchools(new SchoolDTO());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(schools, response.getBody());
        verify(schoolService).getAllSchools();
    }

    @Test
    void queryHello_WithNullCriteria_ShouldReturnHelloWorld() {
        ResponseEntity<Map<String, String>> response = schoolController.queryHello(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("world", response.getBody().get("hello"));
    }

    @Test
    void queryHello_WithCriteria_ShouldReturnHelloWorld() {
        ResponseEntity<Map<String, String>> response = schoolController.queryHello(schoolDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("world", response.getBody().get("hello"));
    }

    @Test
    void createSchool_ShouldReturnCreatedSchool() {
        when(schoolService.createSchool(any(SchoolDTO.class))).thenReturn(schoolDTO);

        ResponseEntity<SchoolDTO> response = schoolController.createSchool(schoolDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(schoolDTO, response.getBody());
        verify(schoolService).createSchool(schoolDTO);
    }

    @Test
    void getSchool_WhenExists_ShouldReturnSchool() {
        when(schoolService.getSchoolById(1L)).thenReturn(Optional.of(schoolDTO));

        ResponseEntity<SchoolDTO> response = schoolController.getSchool(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(schoolDTO, response.getBody());
        verify(schoolService).getSchoolById(1L);
    }

    @Test
    void getSchool_WhenNotExists_ShouldReturnNotFound() {
        when(schoolService.getSchoolById(1L)).thenReturn(Optional.empty());

        ResponseEntity<SchoolDTO> response = schoolController.getSchool(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(schoolService).getSchoolById(1L);
    }

    @Test
    void updateSchool_WhenExists_ShouldReturnUpdatedSchool() {
        when(schoolService.updateSchool(eq(1L), any(SchoolDTO.class))).thenReturn(Optional.of(schoolDTO));

        ResponseEntity<SchoolDTO> response = schoolController.updateSchool(1L, schoolDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(schoolDTO, response.getBody());
        verify(schoolService).updateSchool(1L, schoolDTO);
    }

    @Test
    void updateSchool_WhenNotExists_ShouldReturnNotFound() {
        when(schoolService.updateSchool(eq(1L), any(SchoolDTO.class))).thenReturn(Optional.empty());

        ResponseEntity<SchoolDTO> response = schoolController.updateSchool(1L, schoolDTO);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(schoolService).updateSchool(1L, schoolDTO);
    }

    @Test
    void deleteSchool_ShouldReturnOk() {
        doNothing().when(schoolService).deleteSchool(1L);

        ResponseEntity<Void> response = schoolController.deleteSchool(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(schoolService).deleteSchool(1L);
    }
}
