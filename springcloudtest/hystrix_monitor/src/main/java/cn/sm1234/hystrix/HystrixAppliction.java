package cn.sm1234.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix Dashboard启动类
 */
@SpringBootApplication
@EnableHystrixDashboard //开启Hystrix监控面板
@EnableCircuitBreaker
public class HystrixAppliction {
    public static void main(String[] args){
        SpringApplication.run(HystrixAppliction.class, args);
    }

}
