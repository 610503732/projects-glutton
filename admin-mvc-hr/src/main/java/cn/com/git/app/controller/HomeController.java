package cn.com.git.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用入口
 */
@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);// slf4j日志记录器

    @RequestMapping("/login")
    public String index() {
        logger.info("info:{}","登录页面 ") ;
        return "login" ;
    }


}
