package com.wencom.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wencom.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick")
    public String save() {
        System.out.println("controller running...");
        return "success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        /*
        model: 模型，作用封装数据；
        view: 视图，作用展示数据；
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username", "wencom");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "wencom");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "文康");
        return "success";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "呵呵哒");
        return "success";
    }

    @RequestMapping("/quick6")
    @ResponseBody
    public String save6() {
//        request.setAttribute("username", "呵呵哒");
        return "success";
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public User save7() throws JsonProcessingException {
//        request.setAttribute("username", "呵呵哒");
        User user = new User();
        user.setName("wencom");
        user.setAge(26);

//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(user);

        return user;
    }

    //http://localhost:8080/user/quick9?name=ss&age=12
    @RequestMapping("/quick8")
    @ResponseBody
    public void save8(String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
    }

    //http://localhost:8080/user/quick9?id=1&name=ss&age=12&money=20
    @RequestMapping("/quick9")
    @ResponseBody
    public void save9(User user) {
        System.out.println(user);
    }

    //http://localhost:8080/user/quick10?args=aaa&args=bbb&args=ccc
    @RequestMapping("/quick10")
    @ResponseBody
    public void save10(String[] args) {
        System.out.println(Arrays.asList(args));
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(@RequestBody List<User> userList) {
        System.out.println(Arrays.asList(userList));
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(String username, MultipartFile uploadFile) {
        System.out.println(username);
        System.out.println(uploadFile.getName());
    }
}
