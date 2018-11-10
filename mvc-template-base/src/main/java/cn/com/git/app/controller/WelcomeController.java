package cn.com.git.app.controller;

import cn.com.git.app.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 欢迎页面
 */
@RequestMapping("/welcome")
@Controller
public class WelcomeController {

    private static Logger logger = LoggerFactory.getLogger(WelcomeController.class);// slf4j日志记录器

    @RequestMapping("/index")
    public String index(String name) {
        logger.info("info:{}","欢迎页面 index ") ;
        return "welcome/index" ;
    }

}
