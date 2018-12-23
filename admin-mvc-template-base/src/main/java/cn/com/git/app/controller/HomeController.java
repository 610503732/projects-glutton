package cn.com.git.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 主页
 */
@RequestMapping("/home")
@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);// slf4j日志记录器

    @Value("${server.env.name}")
    private String serverEnvName ;

    @RequestMapping("/index")
    public String index(String name) {
        logger.info("info:{}","主页 index ") ;
        logger.info("info:当前环境 {}",serverEnvName) ;
        return "home/index" ;
    }


}
