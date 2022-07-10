package cn.sm1234.movie.controller;

import cn.sm1234.movie.client.UserController;
import cn.sm1234.movie.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieController {

//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * 电影微服务（没有使用eureka）
     * @return
     */
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public String order(){
//        Integer id = 6;
//
//        //使用RestTemplate远程调用用户微服务
//        /**
//         * 参数一：调用url
//         * 参数二：需要封装的对象类型
//         */
//        User user = restTemplate.getForObject("http://localhost:9001/user/"+id, User.class);
//        System.out.println(user + "正在购票。。。。");
//        return "购票成功";
//    }
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    /**
//     * 电影微服务（使用eureka）
//     * @return
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order(){
//        Integer id = 6;
//
//        // 使用eureka发现微服务
//        // 返回值为什么是List集合？获取所有同名微服务
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("microservice-user");
//        // 没有负载均衡，暂时取第一个
//        ServiceInstance serviceInstance = serviceInstances.get(0);
//        //使用RestTemplate远程调用用户微服务
//        /**
//         * 参数一：调用url
//         * 参数二：需要封装的对象类型
//         */
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);
//        System.out.println(user + "正在购票。。。。");
//        return "购票成功";
//    }

//    @Autowired
//    private LoadBalancerClient client;
//
//    /**
//     * 电影微服务（使用ribbon负载均衡组件）
//     * @return
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order(){
//        Integer id = 6;
//
////        // 使用eureka发现微服务
////        // 返回值为什么是List集合？获取所有同名微服务
////        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("microservice-user");
////        // 没有负载均衡，暂时取第一个
////        ServiceInstance serviceInstance = serviceInstances.get(0);
////        //使用RestTemplate远程调用用户微服务
//
//        //使用Ribbon选择一个服务实例
//        ServiceInstance serviceInstance = client.choose("microservice-user");
//        /**
//         * 参数一：调用url
//         * 参数二：需要封装的对象类型
//         */
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);
//        System.out.println(user + "正在购票。。。。");
//        return "购票成功";
//    }

    /**
     * 电影微服务（使用ribbon负载均衡组件-简化版）
     * @return
     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order(){
//        Integer id = 6;
//        /**
//         * 参数一：调用url
//         * 参数二：需要封装的对象类型
//         */
//        User user = restTemplate.getForObject("http://microservice-user/user/" + id, User.class);
//        System.out.println(user + "正在购票。。。。");
//        return "购票成功";
//    }


//    @Autowired
//    private UserController userController;
//    /**
//     * 电影微服务（使用ribbon负载均衡组件-简化版）
//     * @return
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order(){
//        Integer id = 6;
//        User user = userController.findById(id);
//        System.out.println(user + "正在购票。。。。");
//        return "购票成功";
//    }

//    /**
//     * 电影微服务（使用ribbon负载均衡组件-简化版）
//     * @return
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String order(){
//        Integer id = 6;
//        /**
//         * 参数一：调用url
//         * 参数二：需要封装的对象类型
//         */
//        User user = restTemplate.getForObject("http://microservice-user/user/" + id, User.class);
//        System.out.println(user + "正在购票。。。。");
//        return "购票成功";
//    }
//    public String fallback(){
//        return "熔断。。。。。";
//    }

    @Autowired
    private UserController userController;
    /**
     * 电影微服务（使用ribbon负载均衡组件-简化版）
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(){
        Integer id = 6;
        User user = userController.findById(id);
        System.out.println(user + "正在购票。。。。");
        return "购票成功";
    }
}
