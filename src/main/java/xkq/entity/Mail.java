package xkq.entity;

import lombok.Data;
import org.apache.kafka.common.protocol.types.Field;

@Data
public class Mail {
    private String to;
    private String subject;
    private String content;
    private String filePaht;
}
