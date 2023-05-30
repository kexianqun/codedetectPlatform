package xkq.service;

import xkq.entity.User;

public interface UserService {
    public User getUser(String username, String pwd);
}
