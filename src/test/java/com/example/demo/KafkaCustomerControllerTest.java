package com.example.demo;

import com.example.demo.service.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaCustomerControllerTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void sendMessage() {
        kafkaProducer.sendMessage("Hi i am kafka here");
    }
}
