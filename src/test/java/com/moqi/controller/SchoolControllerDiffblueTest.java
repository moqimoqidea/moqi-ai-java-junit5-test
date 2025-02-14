package com.moqi.controller;

import static org.mockito.Mockito.when;

import com.moqi.dto.SchoolDTO;
import com.moqi.service.SchoolService;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {SchoolController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SchoolControllerDiffblueTest {
    @Autowired
    private SchoolController schoolController;

    @MockBean
    private SchoolService schoolService;

    /**
     * Test {@link SchoolController#getSchool(Long)}.
     * <p>
     * Method under test: {@link SchoolController#getSchool(Long)}
     */
    @Test
    @DisplayName("Test getSchool(Long)")
    @Tag("MaintainedByDiffblue")
    void testGetSchool() throws Exception {
        // Arrange
        SchoolDTO schoolDTO = new SchoolDTO();
        schoolDTO.setAddress("42 Main St");
        schoolDTO.setCreatedAt(1L);
        schoolDTO.setDescription("The characteristics of someone or something");
        schoolDTO.setId(1L);
        schoolDTO.setName("Name");
        schoolDTO.setUpdatedAt(1L);
        Optional<SchoolDTO> ofResult = Optional.of(schoolDTO);
        when(schoolService.getSchoolById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/schools/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(schoolController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"address\":\"42 Main St\",\"description\":\"The characteristics of someone or"
                                        + " something\",\"createdAt\":1,\"updatedAt\":1}"));
    }
}
