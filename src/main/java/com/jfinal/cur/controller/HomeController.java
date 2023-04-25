package com.jfinal.cur.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.cur.interceptor.DoEditProfileInterceptor;
import com.jfinal.cur.interceptor.GlobalLoginUserInterceptor;
import com.jfinal.cur.model.User;
import com.jfinal.cur.service.BlogService;
import com.jfinal.cur.service.CommentService;
import com.jfinal.cur.service.UserService;
import com.jfinal.plugin.activerecord.Record;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/1 15:44
 */
//@Path(value = "/home", viewPath = "/home")
@Before(GlobalLoginUserInterceptor.class)
public class HomeController extends Controller {

    @Inject
    private UserService userService;
    @Inject
    private BlogService blogService;
    @Inject
    private CommentService commentService;

    public void index(){
        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));
    }

    public void profile(){
        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));
        Integer profileUserId = getParaToInt();
        setAttr("profileUser", userService.findUserEntityByUserId(profileUserId));
        setAttr("profileUserBlogNum", blogService.findBlogNumByUserId(profileUserId));
        setAttr("profileUserCommentNum", commentService.findCommentNumByUserId(profileUserId));
    }

    public void editProfile(){
        HttpSession session = getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser.getUserId() == 0){
            setAttr("exceptionMsg", "管理员不能修改资料");
            render("/front/home/exception.html");
        }
        setAttr("loginUser", loginUser);
        if(session.getAttribute("username") != null){
            setAttr("username", session.getAttribute("username"));
            session.removeAttribute("username");
        }
        if(session.getAttribute("oldPassword") != null){
            setAttr("oldPassword", session.getAttribute("oldPassword"));
            session.removeAttribute("oldPassword");
        }
        if(session.getAttribute("newPassword") != null){
            setAttr("newPassword", session.getAttribute("newPassword"));
            session.removeAttribute("newPassword");
        }
        if(session.getAttribute("usernameMsg") != null){
            setAttr("usernameMsg", session.getAttribute("usernameMsg"));
            session.removeAttribute("usernameMsg");
        }
        if(session.getAttribute("oldPasswordMsg") != null){
            setAttr("oldPasswordMsg", session.getAttribute("oldPasswordMsg"));
            session.removeAttribute("oldPasswordMsg");
        }
        if(session.getAttribute("newPasswordMsg") != null){
            setAttr("newPasswordMsg", session.getAttribute("newPasswordMsg"));
            session.removeAttribute("newPasswordMsg");
        }
    }

    @Before(DoEditProfileInterceptor.class)
    public void doEditProfile(@Para("username") String username, @Para("newPassword") String newPassword){
        HttpSession session = getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        Record userRecord = new Record();
        userRecord.set("user_id", loginUser.getUserId()).set("username", username).set("password", newPassword);
        userService.updateUserByUserRecord(userRecord);
        loginUser.setUsername(username);
        loginUser.setPassword(newPassword);
        session.setAttribute("loginUser", loginUser);
        session.setAttribute("usernameMsg", "更改成功, 不信的话重新登录试一下");
        redirect("/home/editProfile");
    }

    public void cancel(){
        HttpSession session = getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser.getUserId() == 0){
            setAttr("exceptionMsg", "管理员不能注销账号");
            render("/front/home/exception.html");
        }
    }

    public void doCancel(){
        HttpSession session = getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        userService.deleteUserByUserId(loginUser.getUserId());
        session.setAttribute("usernameMsg", "账号注销成功");
        session.removeAttribute("loginUser");
        redirect("/");
    }

    public void exit(){
        HttpSession session = getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        session.setAttribute("username", loginUser.getUsername());
        session.setAttribute("usernameMsg", "退出成功");
        session.removeAttribute("loginUser");
        redirect("/");
    }
}
