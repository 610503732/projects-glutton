package cn.com.git.common.entity;

import java.io.Serializable;

/**
 * 服务调用的统一返回传参
 * @author Administrator
 *
 * @param <T>
 */
public class DataResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String message ;

    private Boolean success ;

    private T data ;

    public DataResult() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DataResult(String message, Boolean success, T data) {
        super();
        this.message = message;
        this.success = success;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
