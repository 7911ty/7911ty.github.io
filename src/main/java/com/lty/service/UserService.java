package com.lty.service;

import com.lty.po.User;

public interface UserService {
    User checkUser(String username,String password);
}
