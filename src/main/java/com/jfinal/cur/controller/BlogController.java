package com.jfinal.cur.controller;


import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.cur.interceptor.DoAddOrEditBlogInterceptor;
import com.jfinal.cur.interceptor.GlobalLoginUserInterceptor;
import com.jfinal.cur.model.Blog;
import com.jfinal.cur.model.Comment;
import com.jfinal.cur.model.User;
import com.jfinal.cur.utils.MyPage;
import com.jfinal.cur.service.BlogService;
import com.jfinal.cur.service.CommentService;
import com.jfinal.cur.service.UserService;
import com.jfinal.plugin.activerecord.Record;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/2 20:07
 */
//@Path("/blog")
@Before(GlobalLoginUserInterceptor.class)
public class BlogController extends Controller {

    @Inject
    private UserService userService;
    @Inject
    private BlogService blogService;
    @Inject
    private CommentService commentService;

    public void page(){
        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));

        Integer pageNum = getParaToInt();
        MyPage<Blog> blogPage = blogService.findBlogPageByPageNumThroughMyPage(pageNum);

        Map<Integer, String> userMap = new HashMap<>();
        for(Blog blog : blogPage.getList()){
            User user = userService.findUserEntityByUserId(blog.getUserId());
            if(user == null){
                userMap.put(blog.getUserId(), null);
            }else{
                userMap.put(blog.getUserId(), user.getUsername());
            }
        }
        setAttr("blogPage", blogPage);
        setAttr("userMap", userMap);
    }

    public void searchPage(){
        String searchKeyWord = getPara("searchKeyWord");
        if(searchKeyWord == null){
            redirect("/blog/page/1");
            return;
        }

        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));
        Integer searchPageNum = getParaToInt(0);
        MyPage<Blog> blogSearchPage = blogService.findBlogPageByPageNumThroughMyPage(searchPageNum, searchKeyWord);
        Map<Integer, String> userMap = new HashMap<>();
        for(Blog blog : blogSearchPage.getList()){
            User user = userService.findUserEntityByUserId(blog.getUserId());
            if(user == null){
                userMap.put(blog.getUserId(), null);
            }else{
                userMap.put(blog.getUserId(), user.getUsername());
            }
        }
        setAttr("searchKeyWord", searchKeyWord);
        setAttr("blogSearchPage", blogSearchPage);
        setAttr("userMap", userMap);
    }

    public void add(){
        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));
        if(session.getAttribute("title") != null){
            setAttr("title", session.getAttribute("title"));
            session.removeAttribute("title");
        }
        if(session.getAttribute("titleMsg") != null){
            setAttr("titleMsg", session.getAttribute("titleMsg"));
            session.removeAttribute("titleMsg");
        }
        if(session.getAttribute("content") != null){
            setAttr("content", session.getAttribute("content"));
            session.removeAttribute("content");
        }
        if(session.getAttribute("contentMsg") != null){
            setAttr("contentMsg", session.getAttribute("contentMsg"));
            session.removeAttribute("contentMsg");
        }
    }

    @Before(DoAddOrEditBlogInterceptor.class)
    public void doAdd(@Para("title") String title, @Para("content") String content, @Para("userId") Integer userId){
        Record blogRecord = new Record();
        blogRecord.set("title", title).set("content", content).set("user_id", userId);
        blogService.saveBlogByBlogRecord(blogRecord);
        Integer lastPageNum = blogService.findBlogPageByPageNumThroughMyPage(1).getPages();
        redirect("/blog/page/" + lastPageNum);
    }

    public void edit(){
        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));
        if(session.getAttribute("title") != null){
            setAttr("title", session.getAttribute("title"));
            session.removeAttribute("title");
        }
        if(session.getAttribute("titleMsg") != null){
            setAttr("titleMsg", session.getAttribute("titleMsg"));
            session.removeAttribute("titleMsg");
        }
        if(session.getAttribute("content") != null){
            setAttr("content", session.getAttribute("content"));
            session.removeAttribute("content");
        }
        if(session.getAttribute("contentMsg") != null){
            setAttr("contentMsg", session.getAttribute("contentMsg"));
            session.removeAttribute("contentMsg");
        }
        Integer blogId = getParaToInt();
        Blog blog = blogService.findBlogEntityByBlogId(blogId);
        setAttr("blog", blog);
    }

    @Before(DoAddOrEditBlogInterceptor.class)
    public void doEdit(
            @Para("blogId") Integer blogId,
            @Para("title") String title,
            @Para("content") String content,
            @Para("userId") Integer userId){
        Record blogRecord = new Record();
        blogRecord.set("blog_id", blogId).set("title", title).set("content", content).set("user_id", userId);
        blogService.updateBlogByBlogRecord(blogRecord);
        redirect("/blog/showBlog/" + blogId + "-1");
    }

    public void showBlog(){
        HttpSession session = getSession();
        setAttr("loginUser", session.getAttribute("loginUser"));
        if(session.getAttribute("commentContentMsg") != null){
            setAttr("commentContentMsg", session.getAttribute("commentContentMsg"));
            session.removeAttribute("commentContentMsg");
        }

        Integer blogId = getParaToInt(0);
        Integer commentPageNum = getParaToInt(1);
        Blog blog = blogService.findBlogEntityByBlogId(blogId);
        User blogUser = userService.findUserEntityByUserId(blog.getUserId());
        setAttr("blog", blog);
        setAttr("blogUser", blogUser);

        MyPage<Comment> commentPage = commentService.findCommentPageByBlogIdAndCommentPageNumThroughMyPage(blogId, commentPageNum);
        setAttr("commentPage", commentPage);
    }

    public void delete(){
        Integer blogId = getParaToInt();
        blogService.deleteBlogByBlogId(blogId);
        commentService.deleteCommentByBlogId(blogId);
        redirect("/blog/page/1");
    }
}
