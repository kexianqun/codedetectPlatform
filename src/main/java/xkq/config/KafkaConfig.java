package xkq.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Value("${kafka.topic.clone}")
    String clone;
    @Value("${kafka.topic.cluster}")
    String cluster;
    @Value("${kafka.topic.bugdetect}")
    String bugdetect;

    @Bean
    public NewTopic clone(){
        return new NewTopic(clone, 2, (short) 2);
    }

    @Bean
    public NewTopic bugDetect() {
        return new NewTopic(bugdetect, 2, (short) 2);
    }

    @Bean
    public NewTopic cluster() {
        return new NewTopic(cluster, 2, (short) 2);
    }
}
