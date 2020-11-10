package com.itheima.jobs;

import com.itheima.constant.RedisConstant;
import com.itheima.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @Title: project
 * @Package * @Description:     * @author CodingSir
 * @date 2020/11/910:46
 */
public class ClearImgJob {
    @Autowired
    private JedisPool jedisPool;

    public void clearImg() {
        //根据Redis中保存的两个set集合进行差值计算，获得垃圾图片名称集合
        Set<String> set = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if (set != null) {
            for (String picName : set) {
                System.out.println("自定义任务执行，清理垃圾图片:" + picName);
                QiniuUtils.deleteFileFromQiniu(picName);
                jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES, picName);
            }
        }
    }
}
