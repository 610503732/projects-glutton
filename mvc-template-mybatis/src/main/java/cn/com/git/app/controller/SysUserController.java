package cn.com.git.app.controller;

import cn.com.git.app.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用户路由
 */
@RequestMapping("/sys_user")
@Controller
public class SysUserController {

    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);// slf4j日志记录器

    /**
     * 用户服务
     */
    @Autowired
    private SysUserService sysUserService ;

    @RequestMapping("/index")
    public String index(String name) {
        logger.info("info:{}","用户页面 index ") ;
        return "sys_user/index" ;
    }

}
