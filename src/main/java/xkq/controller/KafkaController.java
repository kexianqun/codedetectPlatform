package xkq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xkq.entity.Book;
import xkq.service.BookProducerService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/book")
public class KafkaController {
    @Value("${kafka.topic.my-topic}")
    String myTopic;
    @Value("${kafka.topic.my-topic2}")
    String myTopic2;
    private final BookProducerService producer;
    private AtomicLong atomicLong = new AtomicLong();

    KafkaController(BookProducerService producer) {
        this.producer = producer;
    }

    @GetMapping("/test")
    public void sendMessageToKafkaTopic() {
        String name="java";
        System.out.println("_------------------------------------------------------_");
        this.producer.sendMessage(myTopic, new Book(atomicLong.addAndGet(1), name));
        this.producer.sendMessage(myTopic2, new Book(atomicLong.addAndGet(1), name));
    }
}
