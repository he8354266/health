package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1616:44
 */
public interface UserService {
    User findByUsername(String username);
}
