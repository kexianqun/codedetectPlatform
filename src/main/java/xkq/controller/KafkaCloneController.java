package xkq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xkq.entity.CloneEntity;
import xkq.service.CloneEmbeddingProducerService;

@RestController
@RequestMapping("/clone")
public class KafkaCloneController {
    @Value("${kafka.topic.clone}")
    String clone;
    private final CloneEmbeddingProducerService producer;

    KafkaCloneController(CloneEmbeddingProducerService producer) {
        this.producer = producer;
    }

    @GetMapping("/java")
    public double sendMessageToKafkaTopic() {
        CloneEntity cloneEntity = new CloneEntity();
        cloneEntity.setId(1);
        cloneEntity.setLanguage("java");
        cloneEntity.setModelVersion("1.1");
        cloneEntity.setText1("public static void main ( String args [ ] ) { }");
        cloneEntity.setText2("public static void main ( String args [ ] ) { hello }");
        return this.producer.getSimilarity(clone,  cloneEntity);

    }


}
