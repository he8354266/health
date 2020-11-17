package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1617:27
 */
public interface UserDao {
    User findByUsername(String username);
}
