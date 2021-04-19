package com.wencom.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    //在目标方法执行之前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("perHandle...");
        String param = request.getParameter("param");
        if(param.equals("true")) {
            return true;
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return false;
        }
//        return true;    //true表示放行，false表示不放行
    }

    //在目标方法执行之后 视图对象返回之前 执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name", "Bruce Lee");
        System.out.println("postHandle...");
    }

    //在流程都执行完毕后 执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
