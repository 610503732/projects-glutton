package cn.com.git.api.hello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hello",path = "/hello")
public interface HelloServiceApi {

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    String sqyHiFromClientOn(@RequestParam(value="name") String name) ;

}
