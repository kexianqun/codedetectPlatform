package xkq.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CloneEntity implements Serializable {
    private long id;
    private String uuid;
    private String text1;
    private String text2;
    /**
     * content language
     * 为了使用那个模型，设置的language
     */
    private String language;
    /**
     * 检测结果
     */
    private String result;

    /**
     * current used model version
     */
    private String modelVersion;

}
