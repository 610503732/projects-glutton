package cn.com.git;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudyEureka {

    public static void main (String args[]){
        SpringApplication.run(StudyEureka.class, args);
    }

}
