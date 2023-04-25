package com.jfinal.cur.service;

import com.jfinal.cur.model.Blog;
import com.jfinal.cur.utils.MyPage;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/2 20:24
 */
public class BlogService {

    /**
     * 获取未分页的所有 Blog 的 List<Blog>
     * @return
     */
    private List<Blog> findAllBlogAsList(){
        List<Blog> blogList = new ArrayList<>();
        List<Record> blogRecordList = Db.findAll("t_blog");
        for(Record blogRecord : blogRecordList){
            Integer commentNum = Db.queryInt("select count(*) from t_comment where blog_id = ?", blogRecord.getInt("blog_id"));
            Blog blog = new Blog(blogRecord.getInt("blog_id"),
                    blogRecord.get("title"),
                    blogRecord.get("content"),
                    blogRecord.getInt("user_id"),
                    commentNum);
            blogList.add(blog);
        }
        return blogList;
    }

    /**
     * 根据搜索关键词获取未分页的所有 Blog 的 List<Blog>
     * @param searchKeyWord
     * @return
     */
    private List<Blog> findAllBlogAsList(String searchKeyWord){
        List<Blog> blogList = new ArrayList<>();
        /*
        SELECT *
        FROM t_blog
        INNER JOIN t_user ON t_blog.user_id = t_user.user_id
        WHERE t_user.username LIKE '%a%' OR t_blog.title LIKE '%a%'
         */
        String sql = "select * from t_blog inner join t_user on t_blog.user_id = t_user.user_id " +
                "where t_user.username like '%" + searchKeyWord + "%' or t_blog.title like '%" + searchKeyWord + "%'";
        List<Record> blogRecordList = Db.find(sql);
//        List<Record> blogRecordList = Db.find("select * from t_blog where title like '%" + searchKeyWord + "%'");
        for(Record blogRecord : blogRecordList){
            Integer commentNum = Db.queryInt("select count(*) from t_comment where blog_id = ?", blogRecord.getInt("blog_id"));
            Blog blog = new Blog(
                    blogRecord.getInt("blog_id"),
                    blogRecord.get("title"),
                    blogRecord.get("content"),
                    blogRecord.getInt("user_id"),
                    commentNum);
            blogList.add(blog);
        }
        return blogList;
    }

    public MyPage<Blog> findBlogPageByPageNumThroughMyPage(Integer pageNum){
        List<Blog> blogList = findAllBlogAsList();
        MyPage<Blog> blogPage = new MyPage<>(blogList, pageNum, 8, 5);
        return blogPage;
    }

    public MyPage<Blog> findBlogPageByPageNumThroughMyPage(Integer pageNum, String searchKeyWord){
        List<Blog> blogList = findAllBlogAsList(searchKeyWord);
        MyPage<Blog> blogPage = new MyPage<>(blogList, pageNum, 8, 5);
        return blogPage;
    }

    public Integer findBlogNumByUserId(Integer userId){
        List<Record> recordList = Db.find("select * from t_blog where user_id = ?", userId);
        return recordList.size();
    }

    public Blog findBlogEntityByBlogId(Integer blogId){
        Record blogRecord = Db.findFirst("select * from t_blog where blog_id = ?", blogId);
        Blog blogEntity = new Blog(
                blogRecord.getInt("blog_id"),
                blogRecord.get("title"),
                blogRecord.get("content"),
                blogRecord.getInt("user_id"));
        return blogEntity;
    }

    public void saveBlogByBlogRecord(Record blogRecord){
        Db.save("t_blog", "blog_id", blogRecord);
    }

    /**
     * 根据 blogId 删除 blog 同时根据 blogId 删除 comment
     * @param blogId
     */
    public void deleteBlogByBlogId(Integer blogId){
        Db.deleteById("t_blog", "blog_id", blogId);
    }

    public void updateBlogByBlogRecord(Record blogRecord) {
        Db.update("t_blog", "blog_id", blogRecord);
    }
}
