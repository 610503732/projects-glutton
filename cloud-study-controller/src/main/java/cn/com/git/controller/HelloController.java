package cn.com.git.controller;

import cn.com.git.api.hello.HelloServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "helloC")
public class HelloController {

    @Autowired
    private HelloServiceApi helloServiceApi ;

    @GetMapping(value="/sayHi")
    public String sayHi(@RequestParam String name){
        return "路由层调用" ;
    }

}
