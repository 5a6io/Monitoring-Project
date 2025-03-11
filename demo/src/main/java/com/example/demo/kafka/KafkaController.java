package com.example.demo.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @PostMapping("/kafka/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);

        return "ok";
    }
}