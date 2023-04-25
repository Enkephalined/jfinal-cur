package com.jfinal.cur.service;

import com.jfinal.cur.model.Comment;
import com.jfinal.cur.model.User;
import com.jfinal.cur.utils.MyPage;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/3 20:47
 */
public class CommentService {

    public Integer findCommentNumByUserId(Integer userId){
        List<Record> recordList = Db.find("select * from t_comment where user_id = ?", userId);
        return recordList.size();
    }

    /**
     * 根据 blogId 获取未分页的所有 Comment 的 List<Comment>
     * @return
     */
    private List<Comment> findAllCommentAsList(Integer blogId){
        List<Comment> commentList = new ArrayList<>();
        List<Record> commentRecordList = Db.find("select * from t_comment where blog_id = ?", blogId);
        for(Record commentRecord : commentRecordList){
            Integer commentId = commentRecord.getInt("comment_id");
            String commentContent = commentRecord.get("comment_content");
//            blogId = commentRecord.getInt("blog_id");//已定义
            Integer userId = commentRecord.getInt("user_id");
            User userEntity = new UserService().findUserEntityByUserId(userId);
            String username = userEntity == null ? "*用户已注销*" : userEntity.getUsername();
            Comment comment = new Comment(commentId, commentContent, blogId, userId, username);
            commentList.add(comment);
        }
        return commentList;
    }

    public MyPage<Comment> findCommentPageByBlogIdAndCommentPageNumThroughMyPage(Integer blogId, Integer commentPageNum){
        List<Comment> commentList = findAllCommentAsList(blogId);
        MyPage<Comment> commentPage = new MyPage<>(commentList, commentPageNum, 6, 5);
        return commentPage;
    }

    public void saveCommentByCommentRecord(Record commentRecord){
        Db.save("t_comment", "comment_id", commentRecord);
    }

    public void deleteCommentByBlogId(Integer blogId){
        Db.delete("delete from t_comment where blog_id = ?", blogId);
    }

    public void deleteCommentByCommentId(Integer commentId){
        Db.deleteById("t_comment", "comment_id", commentId);
    }
}
