package cn.fishland.blog.service.impl;

import cn.fishland.blog.bean.Tag;
import cn.fishland.blog.bean.Type;
import cn.fishland.blog.bean.pojo.Message;
import cn.fishland.blog.mapper.TagMapper;
import cn.fishland.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标签服务类实现类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/28 6:54 下午
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public Map<String, Object> getAll(Integer page, Integer rows) {
        Integer integer = tagMapper.countType();
        if (integer <= 0) {
            return null;
        }
        Integer offset = (page - 1) * rows;

        List<Type> all = tagMapper.getAllByPage(offset, rows);

        Map<String, Object> map = new HashMap<>(2);
        map.put("total", integer);
        map.put("rows", all);
        return map;
    }

    @Override
    @Transactional
    public Message add(Tag tag) {

        // 判断是否为空
        if (StringUtils.isEmpty(tag.getName())) {
            return new Message("名称为空");
        }

        if (tagMapper.existName(tag.getName()) > 0) {
            return new Message("标签已存在");
        }

        tag.setCreateDate(new Date(System.currentTimeMillis()));
        tag.setUpdateDate(new Date(System.currentTimeMillis()));

        // 设置类别为标签
        tag.setType(2);

        tagMapper.addTag(tag);

        return new Message("保存标签成功");
    }

    @Override
    public Message update(Tag tag) {
        // 判断是否为空
        if (StringUtils.isEmpty(tag.getName())) {
            return new Message("名称为空");
        }

        if (tagMapper.exist(tag.getId()) <= 0) {
            return new Message("标签不存在");
        }
        tag.setUpdateDate(new Date(System.currentTimeMillis()));
        tagMapper.update(tag);

        return new Message("更新标签成功");
    }

    @Override
    public Message delete(Integer id) {
        tagMapper.deleteById(id);
        return new Message("删除标签成功");
    }
}
