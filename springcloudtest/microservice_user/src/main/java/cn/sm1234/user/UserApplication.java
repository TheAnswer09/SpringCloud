package cn.sm1234.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户微服务
 */
@SpringBootApplication
@EnableEurekaClient // 开启eureka客户端自动配置
public class UserApplication {

    public static void main(String[] args){
        SpringApplication.run(UserApplication.class, args);
    }
}
