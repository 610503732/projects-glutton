package cn.com.git.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果对象
 * @author Administrator
 *
 */
public class PageResult<T> implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 请求结果提示信息
     */
    private String message ;

    /**
     * 请求成功标识
     */
    private Boolean success ;

    /**
     * 结果集
     */
    private List<T> data ;

    /**
     * 分页
     */
    private Pagination page ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Pagination getPage() {
        return page;
    }

    public void setPage(Pagination page) {
        this.page = page;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
