package com.moqi.controller;

import com.moqi.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @GetMapping("/{content}")
    public Message getMessage(@PathVariable String content) {
        return new Message(content);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return message;
    }
} 