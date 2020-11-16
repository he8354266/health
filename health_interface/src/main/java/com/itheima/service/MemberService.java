package com.itheima.service;

import com.itheima.pojo.Member;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1313:43
 */
public interface MemberService {
    Member findByTelephone(String telephone);

    void add(Member member);
}
