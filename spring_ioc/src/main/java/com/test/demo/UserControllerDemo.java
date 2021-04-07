package com.test.demo;

import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserControllerDemo {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService)app.getBean("userService");
//        UserService userService = new UserServiceImpl();
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
