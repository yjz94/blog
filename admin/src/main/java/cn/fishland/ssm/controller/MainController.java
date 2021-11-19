package cn.fishland.ssm.controller;

import cn.fishland.ssm.bean.User;
import cn.fishland.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 1:33 上午
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public ModelAndView home() {
        try {
            ModelAndView modelAndView = new ModelAndView();
            List<User> all = userService.findAll();
            modelAndView.addObject("users", all);
            modelAndView.setViewName("userList");
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
