package xkq.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MailTemplateEntity implements Serializable {
    private long id;
    private String uuid;
    /***
     * clone, bug_detect, cluster
     */
    private String type;
    /**
     *新年, 端午节, 中秋节, 发送祝福短信
     */
    private Date sendTime;
    private String contentTemplate;
    private Date creatTime;
}
