package xkq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xkq.entity.BugEntity;


import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugsController {
   @Autowired
   private final RedisTemplate<String, Object> redisTemplate;
    private Object BugEntity;

    @Autowired
    public BugsController(@Qualifier("redisTemplate") RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @GetMapping("/bug_detect")
    public String bugdetect() {
        // 生成toke
        List<BugEntity> bugs  = (List< BugEntity >)redisTemplate.opsForValue().get("bugs");

        return bugs.size()+"";

    }
}
