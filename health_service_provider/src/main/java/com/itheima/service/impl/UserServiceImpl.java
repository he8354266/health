package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.PermissionDao;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.pojo.Permission;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1617:26
 */
@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    //根据用户名查询数据库获取用户信息和关联的角色信息，同时需要查询角色关联的权限信息
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return null;
        }
        Integer userId = user.getId();
        //根据用户ID查询对应的角色
        Set<Role> roles = roleDao.findByUserId(userId);
        for (Role role : roles) {
            int roleId = role.getId();
            //根据角色ID查询关联的权限
            Set<Permission> permissions = permissionDao.findByRoleId(roleId);
            role.setPermissions(permissions);
        }
        user.setRoles(roles);
        return user;
    }
}