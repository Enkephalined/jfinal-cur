package com.jfinal.cur.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 17:28
 */
public class _MappingKit {
    public static void mapping(ActiveRecordPlugin activeRecordPlugin){
        activeRecordPlugin.addMapping("t_user", "user_id", User.class);
        activeRecordPlugin.addMapping("t_blog", "blog_id", Blog.class);
        activeRecordPlugin.addMapping("t_comment", "comment_id", Comment.class);
    }
}
