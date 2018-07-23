package cn.com.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run( ControllerApplication.class, args );
    }

}
