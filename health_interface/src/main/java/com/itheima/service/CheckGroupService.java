package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/59:20
 */
public interface CheckGroupService {
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    //分页查询
    PageResult pageQuery(QueryPageBean queryPageBean);

    //根据id查询
    CheckGroup findById(Integer id);

    //查询全部id
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    List<CheckGroup> findAll();

    List<CheckGroup> findCheckGroupByIds(Integer id);
}
