package com.jfinal.cur.routes;

import com.jfinal.config.Routes;
import com.jfinal.cur.controller.BlogController;
import com.jfinal.cur.controller.CommentController;
import com.jfinal.cur.controller.HomeController;
import com.jfinal.cur.controller.IndexController;
import com.jfinal.cur.interceptor.LoginInterceptor;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/6 1:31
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/front");
        add("/", IndexController.class, "/index");
        add("/home", HomeController.class, "/home");
        add("/blog", BlogController.class, "/blog");
        add("/comment", CommentController.class, "/comment");
    }
}
