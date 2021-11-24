package cn.fishland.blog.controller;

import cn.fishland.blog.bean.Article;
import cn.fishland.blog.bean.pojo.Message;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章相关API控制类
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/24 9:33 下午
 */
@RestController
@RequestMapping("/admin")
public class ArticleController {

    @PostMapping("/article/{id}")
    public Message articleAdd(@PathVariable Integer id, String tags, Article article) {

        if (id == null || id <= 0) {
            return new Message("文章id有问题", 1);
        }

        if (StringUtils.isEmpty(tags)) {
            return new Message("文章至少有一个标签", 1);
        }
        return null;
    }

}
