package com.jfinal.cur.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 17:29
 */
public class Blog extends Model<Blog> {

    private Integer blogId;

    private String title;

    private String content;

    private Integer userId;

    private Integer commentNum;

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", commentNum=" + commentNum +
                '}';
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Blog() {
    }

    public Blog(Integer blogId, String title, String content, Integer userId) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Blog(Integer blogId, String title, String content, Integer userId, Integer commentNum) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.commentNum = commentNum;
    }
}
