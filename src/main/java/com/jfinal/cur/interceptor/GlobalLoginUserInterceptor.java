package com.jfinal.cur.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description 全局拦截器,检测当前用户登录状态, 若未登录,则跳转至登录页
 * @create 2023/4/1 19:43
 */
public class GlobalLoginUserInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        HttpSession session = controller.getSession();
        if(session.getAttribute("loginUser") == null){
            session.setAttribute("usernameMsg", "请先登录");
            controller.redirect("/");
        }else{
            invocation.invoke();
        }
    }
}
