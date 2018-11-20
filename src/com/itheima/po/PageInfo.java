package com.itheima.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageInfo<T> implements Serializable {
    private Integer pageIndex =1;//页码
    private Integer pageSize =3;//显示条数
    private Integer totalCount =0; //总条数
    private Integer pageTotalCount =0; //总页数
    //每页显示的数据集合
    private List<T> list = new ArrayList<T>();

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        if (pageIndex==null || pageIndex<1){
            this.pageIndex =1;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (pageSize ==null || pageSize<1){
            this.pageSize =3;
        }
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    //获取总页数
    public Integer getPageTotalCount() {

        this.pageTotalCount = totalCount/pageSize;
        if(totalCount%pageSize!=0){
            this.pageTotalCount ++;
        }
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
