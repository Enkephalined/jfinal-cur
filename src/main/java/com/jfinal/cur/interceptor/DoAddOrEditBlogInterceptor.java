package com.jfinal.cur.interceptor;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.cur.service.BlogService;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/3 23:28
 */
public class DoAddOrEditBlogInterceptor implements Interceptor {

    @Inject
    private BlogService blogService;

    @Override
    public void intercept(Invocation invocation) {
        Controller controller = invocation.getController();
        HttpSession session = controller.getSession();
        String title = controller.getPara("title");
        String content = controller.getPara("content");

        if(title == null || content == null){
            if(title == null)   session.setAttribute("titleMsg", "标题不能为空");
            if(content == null)   session.setAttribute("contentMsg", "内容不能为空");
        }else{
            //正确
            invocation.invoke();
            return;
        }

//        System.out.println(invocation.getActionKey());//    /blog/doAdd
//        System.out.println(invocation.getControllerPath());//   /blog
//        System.out.println(invocation.getMethodName());//   doAdd
//        System.out.println(invocation.getViewPath());//     /front/blog/
        session.setAttribute("title", title);
        session.setAttribute("content", content);
        if(invocation.getMethodName().equals("doAdd")){
            controller.redirect("/blog/add");
        }else{ //invocation.getMethodName().equals("doEdit")
            String blogId = controller.getPara("blogId");
            controller.redirect("/blog/edit/" + blogId);
        }
    }
}
