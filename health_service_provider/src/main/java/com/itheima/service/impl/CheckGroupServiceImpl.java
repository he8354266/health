package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/59:27
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;

    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.add(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        this.setCheckGroupAndCheckItem(checkGroupId, checkitemIds);
    }



    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckGroup> page = checkGroupDao.findByCondition(queryString);
        long total = page.getTotal();
        List<CheckGroup> checkGroupList = page.getResult();
        return new PageResult(total, checkGroupList);
    }

    @Override
    public CheckGroup findById(Integer id) {
        CheckGroup checkGroup = checkGroupDao.findById(id);
        return checkGroup;
    }

    @Override
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id) {
        List<Integer> integerList = checkGroupDao.findCheckItemIdsByCheckGroupId(id);
        return integerList;
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        //修改检查组基本信息，操作检查组t_checkgroup表
        checkGroupDao.edit(checkGroup);
        //清理当前检查组关联的检查项，操作中间关系表t_checkgroup_checkitem表
        checkGroupDao.deleteAssocication(checkGroup.getId());
        //重新建立当前检查组和检查项的关联关系
        Integer checkGroupId = checkGroup.getId();
        System.out.println("============================");
        System.out.println(checkGroupId);
        this.setCheckGroupAndCheckItem(checkGroupId,checkitemIds);
    }

    @Override
    public List<CheckGroup> findAll() {
        List<CheckGroup> checkGroupList=  checkGroupDao.findAll();
        return checkGroupList;
    }

    //建立检查组和检查项多对多关系
    public void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds){
        if(checkitemIds != null && checkitemIds.length > 0){
            for (Integer checkitemId : checkitemIds) {
                Map<String,Integer> map = new HashMap<>();
                map.put("checkgroupId",checkGroupId);
                map.put("checkitemId",checkitemId);
                checkGroupDao.setCheckGroupAndCheckItem(map);
            }
        }
    }
}
