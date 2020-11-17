package com.itheima.dao;

import com.itheima.pojo.Permission;

import java.util.Set;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1617:29
 */
public interface PermissionDao {
    Set<Permission> findByRoleId(int roleId);
}
