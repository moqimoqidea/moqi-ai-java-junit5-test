package com.moqi.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MessageController.class})
@ExtendWith(SpringExtension.class)
class MessageControllerDiffblueTest {
    @Autowired
    private MessageController messageController;

    /**
     * Test {@link MessageController#deleteMessage(String)}.
     * <ul>
     *   <li>Then content string {@code {"content":"Deleted message: Not all who wander are lost"}}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MessageController#deleteMessage(String)}
     */
    @Test
    @DisplayName("Test deleteMessage(String); then content string '{\"content\":\"Deleted message: Not all who wander are lost\"}'")
    @Tag("MaintainedByDiffblue")
    void testDeleteMessage_thenContentStringContentDeletedMessageNotAllWhoWanderAreLost() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/messages/{content}",
                "Not all who wander are lost");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"content\":\"Deleted message: Not all who wander are lost\"}"));
    }

    /**
     * Test {@link MessageController#deleteMessage(String)}.
     * <ul>
     *   <li>Then content string {@code {"content":"Deleted message: Uri Variables"}}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MessageController#deleteMessage(String)}
     */
    @Test
    @DisplayName("Test deleteMessage(String); then content string '{\"content\":\"Deleted message: Uri Variables\"}'")
    @Tag("MaintainedByDiffblue")
    void testDeleteMessage_thenContentStringContentDeletedMessageUriVariables() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/messages/{content}",
                "Uri Variables", "Uri Variables");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(messageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"content\":\"Deleted message: Uri Variables\"}"));
    }
}
