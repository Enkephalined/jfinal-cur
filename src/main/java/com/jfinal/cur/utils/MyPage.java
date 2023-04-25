package com.jfinal.cur.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/4/3 14:53
 */
public class MyPage<T>{

    private List<T> list;//获取分页后的List
    private Integer pageNum;//当前页的页码数
    private Integer pageSize;//每页显示的条数
    private Integer size;//当前页显示的真实条数
    private Integer total;//总记录数
    private Integer pages;//总页数

    private Integer prePage;//上一页的页码
    private Integer nextPage;//下一页的页码
    private boolean isFirstPage;//是否为第一页
    private boolean isLastPage;//是否为最后一页
    private boolean hasPreviousPage;//是否存在上一页
    private boolean hasNextPage;//是否存在下一页
    private Integer navigatePages;//导航分页的页码数------最好是奇数
    private Integer[] navigatepageNums;//导航分页的页码,比如[1, 2, 3, 4, 5]

    /**
     * Constructor
     * @param allList
     * @param pageNum
     * @param pageSize
     * @param navigatePages
     * @return
     */
    public MyPage(List<T> allList, Integer pageNum, Integer pageSize, Integer navigatePages){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = allList.size();
        this.pages = (int) Math.ceil(allList.size() * 1.0 / pageSize);
        this.list = getPageList(allList, pageNum, pageSize);
        this.size = this.list.size();
        this.isFirstPage = pageNum == 1;
        this.isLastPage = pageNum.equals(this.pages);
        this.hasPreviousPage = pageNum > 1;
        this.hasNextPage = pageNum < this.pages;
        this.prePage = pageNum - 1;
        this.nextPage = pageNum + 1;

        this.navigatePages = navigatePages;//5
        this.navigatepageNums = getNavigatepageNums(navigatePages, pageNum, this.pages);
    }

    /**
     * 获取分页后的List
     * @param allList
     * @param pageNum
     * @param pageSize
     * @return
     */
    private List<T> getPageList(List<T> allList, int pageNum, int pageSize) {
        //计算数据的总页数
        int pageCount = (int) Math.ceil(allList.size() * 1.0 / pageSize);

        //如果查询的页数超过了数据的总页数，则返回空列表
        if(pageNum > pageCount){
            return Collections.emptyList();
        }

        //计算数据的起始索引和结束索引
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, allList.size());

        //截取数据并返回结果
        return allList.subList(start, end);
    }

    /**
     * 根据导航分页的页码数获取导航分页的页码 Integer[navigatePages]
     * @param navigatePages
     * @return
     */
    private Integer[] getNavigatepageNums(Integer navigatePages, Integer pageNum, Integer pages){

        if(pages < navigatePages){//总页数小于分页数的情况
            Integer[] navigatepageNums = new Integer[pages];
            for(int i = 0;i < pages;i++){
                navigatepageNums[i] = i + 1;
            }
            return navigatepageNums;
        }

        Integer[] navigatepageNums = new Integer[navigatePages];
        //默认navigatePages是奇数
        /*
        1  ->  12345
        2  ->  12345
        3  ->  12345
        4  ->  23456
        5  ->  34567
        6  ->  45678
        7  ->  56789
        8  ->  678910
        9  ->  678910
        10  ->  678910
         */
        if(pageNum <= (navigatePages + 1) / 2){//1, 2, 3
            for(int j = 0;j < navigatePages;j++){
                navigatepageNums[j] = j + 1;
            }
        }else if(pageNum > pages - (navigatePages + 1) / 2){//8, 9, 10
            for(int i = pages - navigatePages + 1, j = 0;j < navigatePages;i++, j++){
                navigatepageNums[j] = i;
            }
        }else{//4, 5, 6, 7
            for(int i = pageNum - navigatePages / 2, j = 0;j < navigatePages;i++, j++){
                navigatepageNums[j] = i;
            }
        }
        return navigatepageNums;
    }

    public List<T> getList() {
        return list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public boolean getIsFirstPage() {
        return isFirstPage;
    }

    public boolean getIsLastPage() {
        return isLastPage;
    }

    public boolean getHasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean getHasNextPage() {
        return hasNextPage;
    }

    public Integer getNavigatePages() {
        return navigatePages;
    }

    public Integer[] getNavigatepageNums() {
        return navigatepageNums;
    }

    @Override
    public String toString() {
        return "MyPage{" + '\n' +
                "list=" + list + '\n' +
                ", pageNum=" + pageNum + '\n' +
                ", pageSize=" + pageSize + '\n' +
                ", size=" + size + '\n' +
                ", total=" + total + '\n' +
                ", pages=" + pages + '\n' +
                ", prePage=" + prePage + '\n' +
                ", nextPage=" + nextPage + '\n' +
                ", isFirstPage=" + isFirstPage + '\n' +
                ", isLastPage=" + isLastPage + '\n' +
                ", hasPreviousPage=" + hasPreviousPage + '\n' +
                ", hasNextPage=" + hasNextPage + '\n' +
                ", navigatePages=" + navigatePages + '\n' +
                ", navigatepageNums=" + Arrays.toString(navigatepageNums) + '\n' +
                '}';
    }
}
