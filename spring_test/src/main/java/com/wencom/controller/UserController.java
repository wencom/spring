package com.wencom.controller;

import com.wencom.domain.Role;
import com.wencom.domain.User;
import com.wencom.service.RoleService;
import com.wencom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);

        if(user!=null) {
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/list")
    public ModelAndView findAll() {
        List<User> userList = userService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView create() {
        List<Role> roleList = roleService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {
        userService.save(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String delUserById(@PathVariable("userId") Long userId) {
        userService.delUserById(userId);
        return "redirect:/user/list";
    }
}
