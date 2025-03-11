package com.example.demo.kafka;

import com.example.demo.kafka.KafkaEntity;
import com.example.demo.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @PostMapping("/kafka/produce/cluster")
    public String sendMessage(@RequestBody KafkaEntity message) {
        producer.sendMessage(message);

        return "ok";
    }
}