package com.sy.base;

import java.io.Serializable;

/**
 * 返回给客户端模型数据
 * @param <T>
 */
public class PageResp<T> extends BaseResp implements Serializable {

    //总记录数
    private int totalCount ;
    //总页数
    private int totalPage ;
    //当前显示页
    private int currentPage;
    //每页显示条数
    private int pageSize;

    public PageResp() {
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
