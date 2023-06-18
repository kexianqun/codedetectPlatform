package xkq.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DetectResultEntity<T> implements Serializable {
    private Long id;
    private String uuid;
    /**
     * clone cluster  bug_detect
     */
    private String description;
    private String type;
    /**
     * 该结果用户是否查看
     * 0 表示查看
     * 1表示看了
     */
    private int isView;
    private T content;
    private String result;
    private Date creatTime;
}
