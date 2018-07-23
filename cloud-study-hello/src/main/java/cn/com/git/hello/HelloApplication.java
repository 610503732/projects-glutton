package cn.com.git.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run( HelloApplication.class, args );
    }
}
