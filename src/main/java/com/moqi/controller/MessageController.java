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
        return new Message(content);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        log.info("Received POST request to /api/messages with body: {}", message);
        return new Message(message.getContent());
    }

    @DeleteMapping("/{content}")
    public Message deleteMessage(@PathVariable String content) {
        log.info("Received DELETE request to /api/messages/{} with path variable", content);
        return new Message("Deleted message: " + content);
    }

    @PutMapping("/{content}")
    public Message updateMessage(@PathVariable String content, @RequestBody Message message) {
        log.info("Received PUT request to /api/messages/{} with path variable and body: {}", content, message);
        return new Message("Updated message from '" + content + "' to '" + message.getContent() + "'");
    }
} 