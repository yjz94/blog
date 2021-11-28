package cn.fishland.blog.service.impl;

import cn.fishland.blog.bean.Type;
import cn.fishland.blog.bean.pojo.Message;
import cn.fishland.blog.mapper.TypeMapper;
import cn.fishland.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类别相关服务器实现类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/25 9:49 下午
 */
@Service

public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public Map<String, Object> getAll() {
        Integer integer = typeMapper.countType();
        if (integer <= 0) {
            return null;
        }
        List<Type> all = typeMapper.getAll();

        Map<String, Object> map = new HashMap<>(2);
        map.put("total", integer);
        map.put("rows", all);
        return map;
    }

    @Override
    public Map<String, Object> getAll(Integer page, Integer rows) {
        Integer integer = typeMapper.countType();
        if (integer <= 0) {
            return null;
        }
        Integer offset = (page - 1) * rows;

        List<Type> all = typeMapper.getAllByPage(offset, rows);

        Map<String, Object> map = new HashMap<>(2);
        map.put("total", integer);
        map.put("rows", all);
        return map;
    }

    @Override
    @Transactional
    public Message add(Type type) {

        // 判断是否为空
        if (StringUtils.isEmpty(type.getName())) {
            return new Message("名称为空");
        }

        if (typeMapper.existName(type.getName()) > 0) {
            return new Message("类别已存在");
        }

        type.setCreateDate(new Date(System.currentTimeMillis()));
        type.setUpdateDate(new Date(System.currentTimeMillis()));

        // 设置类别
        type.setType(1);

        typeMapper.addType(type);

        return new Message("保存类别成功");
    }

    @Override
    public Message update(Type type) {
        // 判断是否为空
        if (StringUtils.isEmpty(type.getName())) {
            return new Message("名称为空");
        }

        if (typeMapper.exist(type.getId()) <= 0) {
            return new Message("类别不存在");
        }
        type.setUpdateDate(new Date(System.currentTimeMillis()));
        typeMapper.update(type);

        return new Message("更新类别成功");
    }

    @Override
    public Message delete(Integer id) {
        typeMapper.deleteById(id);
        return new Message("删除类别成功");
    }
}
