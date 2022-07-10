package cn.sm1234.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关微服务
 */
@SpringBootApplication
@EnableZuulProxy // 开启网关的代理功能
public class GateWayApplication {

    public static void main(String[] args){
        SpringApplication.run(GateWayApplication.class, args);
    }

}
