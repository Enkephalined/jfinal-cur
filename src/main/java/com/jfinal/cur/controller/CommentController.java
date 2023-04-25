package com.jfinal.cur.controller;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.core.paragetter.Para;
import com.jfinal.cur.interceptor.GlobalLoginUserInterceptor;
import com.jfinal.cur.model.Comment;
import com.jfinal.cur.service.CommentService;
import com.jfinal.cur.utils.MyPage;
import com.jfinal.plugin.activerecord.Record;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description 感觉这个不是很需要, comment 都放在 BlogController 也行
 * @create 2023/4/3 20:48
 */
//@Path("/comment")
@Before(GlobalLoginUserInterceptor.class)
public class CommentController extends Controller {

    @Inject
    private CommentService commentService;

    public void doAdd(
            @Para("blogId") Integer blogId,
            @Para("commentPageNum") Integer commentPageNum,
            @Para("userId") Integer userId,
            @Para("commentContent") String commentContent){
        HttpSession session = getSession();
        if(commentContent == null){
            session.setAttribute("commentContentMsg", "评论不能为空");
            redirect("/blog/showBlog/" + blogId + "-" + commentPageNum);
            return;
        }
        Record commentRecord = new Record();
        commentRecord.set("comment_content", commentContent).set("blog_id", blogId).set("user_id", userId);
        commentService.saveCommentByCommentRecord(commentRecord);
        Integer lastCommentPageNum = commentService.findCommentPageByBlogIdAndCommentPageNumThroughMyPage(blogId, 1).getPages();
        redirect("/blog/showBlog/" + blogId + "-" + lastCommentPageNum);
    }

    public void delete(){
        Integer commentId = getParaToInt(0);
        Integer blogId = getParaToInt(1);
        Integer commentPageNum = getParaToInt(2);
        commentService.deleteCommentByCommentId(commentId);
        MyPage<Comment> commentPage = commentService.findCommentPageByBlogIdAndCommentPageNumThroughMyPage(blogId, commentPageNum);
        if(commentPage.getSize() == 0 && commentPageNum != 1){
            commentPageNum --;
        }
        redirect("/blog/showBlog/" + blogId + "-" + commentPageNum);
    }
}
