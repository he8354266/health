package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/59:28
 */
public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map map);

    Page<CheckGroup> findByCondition(String queryString);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

     void edit(CheckGroup checkGroup);
     void deleteAssocication(Integer id);

    List<CheckGroup> findAll();
}
