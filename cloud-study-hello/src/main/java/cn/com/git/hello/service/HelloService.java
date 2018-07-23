package cn.com.git.hello.service;

import cn.com.git.api.hello.HelloServiceApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloService implements  HelloServiceApi{

    @Override
    public String sqyHiFromClientOn(@RequestParam("name") String name) {
        return "hello ! " + name ;
    }
}
