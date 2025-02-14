package com.moqi.controller;

import com.moqi.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @GetMapping("/{content}")
    public Message getMessage(@PathVariable String content) {
        log.info("Received GET request to /api/messages/{} with path variable", content);
        Message response = new Message(content);
        log.info("Returning response: {}", response);
        return response;
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        log.info("Received POST request to /api/messages with body: {}", message);
        Message response = new Message(message.getContent());
        log.info("Returning response: {}", response);
        return response;
    }
} 