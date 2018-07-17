package cn.com.git.common.entity;

import java.io.Serializable;

/**
 * 分页对象
 * @author Administrator
 *
 */
public class Pagination implements Serializable{

    /**
     * 当前页码
     */
    private int pageNumber ;

    /**
     * 每页记录条数
     */
    private int pageSize ;

    /**
     * 总计条数
     */
    private long total ;

    public Pagination(int pageNumber, int pageSize, long total) {
        super();
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }



}
