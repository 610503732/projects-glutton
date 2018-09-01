package cn.com.git.app.entity.pojo;

import java.io.Serializable;

/**
 * 用户
 */
public class SysUser implements Serializable {

    /**
     * 用户编号
     */
    private Integer id ;
    /**
     * 用户名称
     */
    private String name ;

    /**
     * 登陆密码
     */
    private String password ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
