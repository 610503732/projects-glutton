package cn.com.git.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sys_user")
@Controller
public class SysUserController {

    @RequestMapping("/index")
    public String index(String name) {

        return "sys_user/index" ;
    }

}
