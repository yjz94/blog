package cn.fishland.blog.service;

import cn.fishland.blog.bean.Type;
import cn.fishland.blog.bean.pojo.Message;

import java.util.Map;

/**
 * 类型服务
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/25 9:48 下午
 */
public interface TypeService {

    /**
     * 获得所有类型
     *
     * @return 类型集合
     */
    Map<String, Object> getAll();

    /**
     * 获得所有类型,通过分页
     *
     * @param page 当前页数
     * @param rows 每页行数
     * @return 类型集合
     */
    Map<String, Object> getAll(Integer page, Integer rows);

    /**
     * 新增类别
     *
     * @param type 类别相关信息
     * @return 返回操作信息
     */
    Message add(Type type);

    /**
     * 修改类别内容
     *
     * @param type 类别信息
     * @return 返回操作信息
     */
    Message update(Type type);

    /**
     * 删除类别
     *
     * @param id 类别ID
     * @return 返回操作信息
     */
    Message delete(Integer id);
}
