package xkq.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClusterEntity implements Serializable {
    private long id;
    private String uuid;
    /**
     * cluster类型
     */
    private String type;

    /***
     * type description
     */
    private String description;
    /**
     * c++,c,java, javascript,solidity,go
     */
    private String language;

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
