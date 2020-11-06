package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.Setmeal;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/611:13
 */
public interface SetmealService {
    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult pageQuery(QueryPageBean queryPageBean);
}
