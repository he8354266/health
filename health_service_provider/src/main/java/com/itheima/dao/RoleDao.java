package com.itheima.dao;

import com.itheima.pojo.Role;

import java.util.Set;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1617:28
 */
public interface RoleDao {
    Set<Role> findByUserId(int userId);
}
