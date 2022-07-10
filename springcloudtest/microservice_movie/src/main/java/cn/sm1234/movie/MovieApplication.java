package cn.sm1234.movie;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 电影微服务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 开启Feign的自动配置
@EnableHystrix // 开启熔断功能
public class MovieApplication {
    public static void main(String[] args){
        SpringApplication.run(MovieApplication.class, args);
    }

    /**
     * 初始化RestTemplate
     * @return
     */
    @Bean
    @LoadBalanced // Ribbon负载均衡组件
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
