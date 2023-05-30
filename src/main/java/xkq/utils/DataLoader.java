package xkq.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import xkq.entity.User;
import xkq.service.UserService;

@Component
public class DataLoader implements CommandLineRunner {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private UserService userService;
    @Autowired
    public DataLoader(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Override
    public void run(String... args) throws Exception {
        Object data = redisTemplate.opsForValue().get("user");
        if(data==null){
            User user = userService.getUser("xqke", "123456");
            redisTemplate.opsForValue().set("user",user);
        }

    }
}
