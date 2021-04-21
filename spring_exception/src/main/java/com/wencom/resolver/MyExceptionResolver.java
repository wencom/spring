package com.wencom.resolver;

import com.wencom.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();

        if(e instanceof ClassCastException) {
            modelAndView.addObject("info", "类型转换异常");
        }else if (e instanceof MyException) {
            modelAndView.addObject("info", "自定义异常");
        }

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
