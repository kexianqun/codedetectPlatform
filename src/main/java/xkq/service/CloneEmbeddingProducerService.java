package xkq.service;

import xkq.entity.CloneEntity;

public interface CloneEmbeddingProducerService {
     double getSimilarity(String topic, CloneEntity cloneEntity);
}
