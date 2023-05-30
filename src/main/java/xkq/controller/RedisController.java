package xkq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xkq.entity.User;

@RestController
public class RedisController {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisController(@Qualifier("redisTemplate") RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/set")
    public void set() {
        User user = new User();
        user.setId(12l);
        user.setUuid("2323424");
        user.setUsername("kxq");
        user.setPassword("123456");
        System.out.println(user.toString());
        redisTemplate.opsForValue().set("user", user);
    }
    @GetMapping("get")
    public String get(){
        return redisTemplate.opsForValue().get("user").toString();
    }
}
