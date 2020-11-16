package com.itheima.dao;

import com.itheima.pojo.Member;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1216:47
 */
public interface MemberDao {
    Member findByTelephone(String telephone);
    void add(Member member);
}
