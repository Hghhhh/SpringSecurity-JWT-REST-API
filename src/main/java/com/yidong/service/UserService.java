package com.yidong.service;

import com.yidong.model.User;

import java.util.Map;

public interface UserService {
    Map<String,String> login(String account, String password);
    String refresh(String oldToken);

}
