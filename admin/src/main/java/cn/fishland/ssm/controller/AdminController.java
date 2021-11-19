package cn.fishland.ssm.controller;

import cn.fishland.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * TODO
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 1:33 上午
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public ModelAndView findAll() {
        ModelAndView modelAndView = null;
        try {
            modelAndView = new ModelAndView();
            modelAndView.addObject("users", userService.findAll());
            modelAndView.setViewName("/admin/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
