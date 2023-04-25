package com.jfinal.cur.interceptor;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.cur.model.User;
import com.jfinal.cur.service.UserService;
import com.jfinal.plugin.activerecord.Record;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 20:22
 */
public class LoginInterceptor implements Interceptor {

    @Inject
    private UserService userService;

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        String username = controller.getPara("username");
        String password = controller.getPara("password");
        User user = userService.findUserEntityByUsername(username);
        if(user == null){
            controller.setAttr("usernameMsg", "用户名不存在");
        }else if(!password.equals(user.getPassword())){
            controller.setAttr("passwordMsg", "密码错误");
        }else{
            controller.setAttr("loginUser", user);
            invocation.invoke();
            return;
        }
        controller.setAttr("username", username);
        controller.setAttr("password", password);
        controller.render("/front/index/index.html");
    }
}
