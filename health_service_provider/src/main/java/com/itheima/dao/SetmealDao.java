package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/611:16
 */
public interface SetmealDao {

    void add(Setmeal setmeal);

    void setSetmealAndCheckGroup(Map map);

    Page<Setmeal> findByCondition(String queryString);

    List<Setmeal> findAll();

    Setmeal findById(int id);

    Setmeal findByIds(int id);
}
