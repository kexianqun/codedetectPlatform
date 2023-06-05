package xkq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import xkq.entity.CloneEntity;
import xkq.utils.FlaskInterfaceTool;

@Service
public class CloneEmbeddingConsumerServiceImpl {

    private final Logger logger;

    {
        logger = LoggerFactory.getLogger(CloneEmbeddingConsumerServiceImpl.class);
    }
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"${kafka.topic.clone}"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> bookConsumerRecord) {
        try {
            String[] tokens = {"contract", "{", "}"};
            String re = tokens.toString();
            CloneEntity entity = objectMapper.readValue(bookConsumerRecord.value(), CloneEntity.class);

            String url = "http://127.0.0.1:8081/embedding/java";

            String result = FlaskInterfaceTool.getResByUrl(url,"POST", entity);
            System.out.println("***********************************************");
            System.out.println(re);
            System.out.println(entity.getText1());
            System.out.println(entity.getText2());
            logger.info("embeddings:{}", result);
            logger.info("消费者消费topic:{} partition:{}的消息-{}", bookConsumerRecord.topic(), bookConsumerRecord.partition(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
