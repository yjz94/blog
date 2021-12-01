package cn.fishland.blog.service;

import cn.fishland.blog.bean.Tag;
import cn.fishland.blog.bean.pojo.Message;

import java.util.Map;

/**
 * 标签服务类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/28 6:48 下午
 */
public interface TagService {

    /**
     * 获得所有标签,通过分页
     *
     * @param page 当前页数
     * @param rows 每页行数
     * @return 标签集合
     */
    Map<String, Object> getAll(Integer page, Integer rows);

    /**
     * 新增标签
     *
     * @param tag 标签相关信息
     * @return 返回操作信息
     */
    Message add(Tag tag);

    /**
     * 修改标签内容
     *
     * @param tag 标签信息
     * @return 返回操作信息
     */
    Message update(Tag tag);

    /**
     * 删除标签
     *
     * @param id 标签ID
     * @return 返回操作信息
     */
    Message delete(Integer id);
}
