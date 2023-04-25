package com.jfinal.cur.interceptor;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.cur.service.UserService;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 23:58
 */
public class RegisterInterceptor implements Interceptor {

    @Inject
    private UserService userService;

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        String username = controller.getPara("username");
        String password = controller.getPara("password");
        if(userService.findUserEntityByUsername(username) != null){
            controller.setAttr("usernameMsg", "用户名已存在");
            controller.setAttr("username", username);
            controller.setAttr("password", password);
            controller.render("/front/index/register.html");
        }else{
            invocation.invoke();
        }
    }
}
