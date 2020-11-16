package com.itheima.service;

import com.itheima.entity.Result;

import java.util.Map;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/1215:59
 */
public interface OrderService {
    Result order(Map map) throws Exception;

    Map findById(int id);
}
