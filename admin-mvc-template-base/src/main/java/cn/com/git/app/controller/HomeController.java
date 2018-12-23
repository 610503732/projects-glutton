package cn.com.git.app.controller;

import cn.com.git.app.entity.pojo.SysUser;
import cn.com.git.app.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 主页
 */
@RequestMapping("/home")
@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);// slf4j日志记录器

    @Value("${server.env.name}")
    private String serverEnvName ;

    @Autowired
    private SysUserService sysUserService ;

    @RequestMapping("/index")
    public String index() {
        logger.info("info:{}","主页 index ") ;
        logger.info("info:当前环境 {}",serverEnvName) ;
        return "home/index" ;
    }


    @RequestMapping("/user")
    @ResponseBody
    public String user(@RequestParam("id") int id) {
        SysUser user =  sysUserService.findUserById(id);
        logger.info("info: 用户{}",user.toString()) ;
        return user.toString() ;
    }

}
