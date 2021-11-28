package cn.fishland.blog.controller;

import cn.fishland.blog.bean.Type;
import cn.fishland.blog.bean.pojo.Message;
import cn.fishland.blog.service.TypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 文章类别控制类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/24 11:51 下午
 */
@RestController
@RequestMapping("/admin")
public class TypeController {

    Logger log = Logger.getLogger(TypeController.class);

    @Autowired
    TypeService typeService;

    /**
     * 获得全部类别信息
     *
     * @return 数据
     */
    @GetMapping("type")
    public Map<String, Object> typeAll(Integer page, Integer rows) {
        try {
            return typeService.getAll(page, rows);
        } catch (Exception e) {
            log.info(String.format("add type error=[%s]", e.getMessage()));
            return null;
        }
    }

    /**
     * 新增类别
     *
     * @param type 类别相关信息
     * @return 存储返回数据
     */
    @PostMapping("/type")
    public Message typeAdd(Type type) {
        try {
            return typeService.add(type);
        } catch (Exception e) {
            log.info(String.format("add type error=[%s]", e.getMessage()));
            return new Message("error", 1);
        }
    }

    /**
     * 修改类别
     *
     * @param type 类别信息
     * @return 返回提示信息
     */
    @PutMapping("/type")
    public Message typeUpdate(Type type) {
        if (type.getId() == null || type.getId() < 0) {
            return new Message("类别ID存在问题");
        }
        try {
            return typeService.update(type);
        } catch (Exception e) {
            log.info(String.format("update type error=[%s]", e.getMessage()));
            return new Message("error", 1);
        }
    }

    @DeleteMapping("/type")
    public Message typeDelete(Type type) {
        if (type == null || type.getId() == null || type.getId() < 0) {
            return new Message("类别ID存在问题");
        }
        try {
            return typeService.delete(type.getId());
        } catch (Exception e) {
            log.info(String.format("delete type error=[%s]", e.getMessage()));
            return new Message("error", 1);
        }
    }

}
