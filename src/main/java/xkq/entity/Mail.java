package xkq.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Mail {
    private String to;
    private String subject;
    private String content;
    private String filepath;
    private Date creatTime;
}
