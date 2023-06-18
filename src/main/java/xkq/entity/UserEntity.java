package xkq.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserEntity implements Serializable {
    private Long id;
    private String uuid;
    private String role;
    private String name;
    private String age;
    private String username; // 用户名
    private String password; // 密码
    private String email;
    /**
     * 是否查看的检测结果
     */
    private long notView;
    private Date createTime;
}
