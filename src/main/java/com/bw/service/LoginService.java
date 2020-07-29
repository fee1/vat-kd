package com.bw.service;

import com.bw.model.TYh;

/**
 * 登录service
 * @author zxf
 */
public interface LoginService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public TYh login(String username, String password);

}
