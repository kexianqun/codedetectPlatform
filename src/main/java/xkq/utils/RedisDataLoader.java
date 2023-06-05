package xkq.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import xkq.entity.BugEntity;
import xkq.entity.User;
import xkq.service.BugService;
import xkq.service.UserService;

import java.util.List;

@Component
public class RedisDataLoader implements CommandLineRunner {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private BugService bugService;
    @Autowired
    private UserService userService;
    @Autowired
    public RedisDataLoader(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    List<BugEntity> getBugeEmbedings(){
           return bugService.getAllBugs();
    }
    @Override
    public void run(String... args) throws Exception {
        Object data = redisTemplate.opsForValue().get("user");
        if(data==null){
            User user = userService.getUser("xqke", "123456");
            redisTemplate.opsForValue().set("user",user);
        }
       Object bugs = redisTemplate.opsForValue().get("bugs");
        if(bugs == null){
            List<BugEntity> bugeEmbedings = getBugeEmbedings();
            redisTemplate.opsForValue().set("bugs",bugeEmbedings);
        }
    }
}
