package cn.com.git.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面原型 控制器
 */
@RequestMapping("/model")
@Controller
public class ModelController {

    private static Logger logger = LoggerFactory.getLogger(ModelController.class);// slf4j日志记录器

//    @RequestMapping("/page/{index}")
//    public String index(@PathVariable("index") Integer index) {
//        logger.info("info:{}","页面 "+ index) ;
//        return "model/" + index ;
//    }

    @RequestMapping("/button")
    public String index( ) {
        logger.info("info:{}","按钮页面 ") ;
        return "model/button"  ;
    }


}
