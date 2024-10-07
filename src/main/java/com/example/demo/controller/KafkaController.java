package com.example.demo.controller;

import com.example.demo.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProdcuer;

    public KafkaController(KafkaProducer kafkaProdcuer) {
        this.kafkaProdcuer = kafkaProdcuer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProdcuer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
