package com.jfinal.cur.interceptor;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.cur.model.User;
import com.jfinal.cur.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/2 17:27
 */
public class DoEditProfileInterceptor implements Interceptor {

    @Inject
    private UserService userService;

    private boolean isValid(String str){
        String pattern = "^[a-zA-Z0-9_]{4,10}$";
        return str.matches(pattern);
    }

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        HttpSession session = controller.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        String username = controller.get("username");
        String oldPassword = controller.get("oldPassword");
        String newPassword = controller.get("newPassword");

        if(username == null || oldPassword == null || newPassword == null){
            if(username == null) session.setAttribute("usernameMsg", "用户名不能为空");
            if(oldPassword == null) session.setAttribute("oldPasswordMsg", "旧密码不能为空");
            if(newPassword == null) session.setAttribute("newPasswordMsg", "新密码不能为空");
        }else if(!username.equals(loginUser.getUsername()) && userService.findUserEntityByUsername(username) != null){
            session.setAttribute("usernameMsg", "用户名已存在");
        }else if(!isValid(username)){
            session.setAttribute("usernameMsg", "用户名格式错误");
        }else if(!oldPassword.equals(loginUser.getPassword())){
            session.setAttribute("oldPasswordMsg", "旧密码错误");
        }else if(!isValid(newPassword)){
            session.setAttribute("newPasswordMsg", "新密码格式错误");
        }else if(username.equals(loginUser.getUsername()) && oldPassword.equals(newPassword)){
            session.setAttribute("usernameMsg", "您似乎什么也没有改");
        }else{
            //正确
            invocation.invoke();
            return;
        }
        session.setAttribute("username", username);
        session.setAttribute("oldPassword", oldPassword);
        session.setAttribute("newPassword", newPassword);
        controller.redirect("/home/editProfile");
    }
}
