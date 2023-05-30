package xkq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xkq.entity.User;
import xkq.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(String username, String pwd) {
        return userMapper.getUserNameAndPwd(username,pwd);
    }
}
