package xkq.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserAndDetectResultEntity implements Serializable {
    private long id;
    private String uuid;
    private String userUUid;
    private String detectResultUUid;
    private Date creatTime;
}
