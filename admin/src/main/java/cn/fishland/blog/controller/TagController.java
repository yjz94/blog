package cn.fishland.blog.controller;

import cn.fishland.blog.bean.Tag;
import cn.fishland.blog.bean.pojo.Message;
import cn.fishland.blog.service.TagService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 文章标签控制类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/24 11:51 下午
 */
@RestController
@RequestMapping("/admin")
public class TagController {

    Logger log = Logger.getLogger(TagController.class);

    @Autowired
    TagService tagService;

    /**
     * 获得全部类别信息
     *
     * @return 数据
     */
    @GetMapping("/tag")
    public Map<String, Object> typeAll(Integer page, Integer rows) {
        try {
            return tagService.getAll(page, rows);
        } catch (Exception e) {
            log.info(String.format("add tag error=[%s]", e.getMessage()));
            return null;
        }
    }

    /**
     * 新增类别
     *
     * @param tag 类别相关信息
     * @return 存储返回数据
     */
    @PostMapping("/tag")
    public Message typeAdd(Tag tag) {
        try {
            return tagService.add(tag);
        } catch (Exception e) {
            log.info(String.format("add tag error=[%s]", e.getMessage()));
            return new Message("error", 1);
        }
    }

    /**
     * 修改类别
     *
     * @param tag 类别信息
     * @return 返回提示信息
     */
    @PutMapping("/tag")
    public Message typeUpdate(Tag tag) {
        if (tag.getId() == null || tag.getId() < 0) {
            return new Message("类别ID存在问题");
        }
        try {
            return tagService.update(tag);
        } catch (Exception e) {
            log.info(String.format("update tag error=[%s]", e.getMessage()));
            return new Message("error", 1);
        }
    }

    @DeleteMapping("/tag")
    public Message typeDelete(Tag tag) {
        if (tag == null || tag.getId() == null || tag.getId() < 0) {
            return new Message("类别ID存在问题");
        }
        try {
            return tagService.delete(tag.getId());
        } catch (Exception e) {
            log.info(String.format("delete tag error=[%s]", e.getMessage()));
            return new Message("error", 1);
        }
    }

}
