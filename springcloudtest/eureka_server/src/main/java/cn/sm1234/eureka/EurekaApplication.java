package cn.sm1234.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 开启eureka服务端自动配置
public class EurekaApplication {

    public static void main(String[] agrs){
        SpringApplication.run(EurekaApplication.class,agrs);
    }
}
