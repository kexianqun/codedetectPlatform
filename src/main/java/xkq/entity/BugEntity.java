package xkq.entity;

import lombok.Data;

@Data
public class BugEntity {
    private long id;
    private String uuid;
    /**
     * bug类型
     */
    private String type;
    /**
     * c++,c,java, javascript,solidity,go
     */
    private String language;
    /***
     * bug description
     */
    private String description;


    /**
     * code content( function, solidity contract)
     */
    private String content;

    /***
     * get embeddings from pre-trained model of content;
     */
    private String embeddings;

    /***
     * 最新模型的版本
     */
    private String modelVersion;

    /**
     * 当前使用的模型得到的embeddings
     */
    private String currentModelVersion;
}
