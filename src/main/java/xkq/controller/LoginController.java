package xkq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xkq.entity.User;
import xkq.service.UserService;
import xkq.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    @GetMapping("/getUser")
    public User hello() {
       return userService.getUser("xqke","123456");
    }

    @GetMapping("login")
    public String login(User user) {
        // 生成toke
        User userInfo = new User();
        userInfo.setId(1L);
        userInfo.setUsername("admin");
        userInfo.setPassword("123456");
        return jwtUtils.generateToken(userInfo);

    }
}
