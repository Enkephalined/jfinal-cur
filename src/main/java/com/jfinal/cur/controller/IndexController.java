package com.jfinal.cur.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.cur.interceptor.LoginInterceptor;
import com.jfinal.cur.interceptor.RegisterInterceptor;
import com.jfinal.cur.service.UserService;
import com.jfinal.cur.validator.LoginValidator;
import com.jfinal.cur.validator.RegisterValidator;
import com.jfinal.plugin.activerecord.Record;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 18:22
 */
//@Path(value = "/", viewPath = "/index")
public class IndexController extends Controller {

    @Inject
    private UserService userService;

    public void index(){
        HttpSession session = getSession();
        if(session.getAttribute("username") != null)    setAttr("username", session.getAttribute("username"));
        if(session.getAttribute("password") != null)    setAttr("password", session.getAttribute("password"));
        if(session.getAttribute("usernameMsg") != null)    setAttr("usernameMsg", session.getAttribute("usernameMsg"));
        if(session.getAttribute("passwordMsg") != null)    setAttr("passwordMsg", session.getAttribute("passwordMsg"));
        session.invalidate();
    }

    @Before({LoginValidator.class, LoginInterceptor.class})
    public void login(){
        HttpSession session = getSession();
        session.setAttribute("loginUser", getAttr("loginUser"));
        redirect("/home");
    }

    public void register(){}

    @Before({RegisterValidator.class, RegisterInterceptor.class})
    public void doRegister(){
        String username = getPara("username");
        String password = getPara("password");
        Record userRecord = new Record().set("username", username).set("password", password);
        userService.saveUserByUserRecord(userRecord);
        HttpSession session = getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("usernameMsg", "注册成功");
        redirect("/");
    }

}
