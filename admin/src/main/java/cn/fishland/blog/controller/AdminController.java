package cn.fishland.blog.controller;

import cn.fishland.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 后台控制器
 *
 * @author fishland
 * @version 1.0
 * @date 2021/11/19 1:33 上午
 */
@Controller
public class AdminController {

    @Autowired
    AuthService authService;

    @RequestMapping("/auth")
    public ModelAndView auth(String code, String name, String password, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        // 获得验证码
        String serviceCode = (String) session.getAttribute("code");
        if (StringUtils.isEmpty(serviceCode) || !serviceCode.equals(code)) {
            modelAndView.addObject("message", "验证码错误");
            modelAndView.setViewName("admin/login");
            return modelAndView;
        }

        String key = session.getServletContext().getInitParameter("key");
        boolean authentication = authService.authentication(key, name, password);
        if (authentication) {
            session.setAttribute("name", name);
            modelAndView.setViewName("redirect:/admin/index");
            return modelAndView;
        }

        modelAndView.addObject("message", "名称或密码错误");
        modelAndView.setViewName("admin/login");
        return modelAndView;
    }

}
