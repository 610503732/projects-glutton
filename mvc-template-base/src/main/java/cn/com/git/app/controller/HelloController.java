package cn.com.git.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(String name) {

        return "hello/index" ;
    }

}
