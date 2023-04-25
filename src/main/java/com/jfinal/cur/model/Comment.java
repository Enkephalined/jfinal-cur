package com.jfinal.cur.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 17:29
 */
public class Comment extends Model<Comment> {

    private Integer commentId;

    private String commentContent;

    private Integer blogId;

    private Integer userId;

    private String username;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", blogId=" + blogId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Comment() {
    }

    public Comment(Integer commentId, String commentContent, Integer blogId, Integer userId, String username) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.blogId = blogId;
        this.userId = userId;
        this.username = username;
    }
}