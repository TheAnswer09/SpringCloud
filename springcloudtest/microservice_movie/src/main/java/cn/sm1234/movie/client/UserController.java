package cn.sm1234.movie.client;

import cn.sm1234.movie.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户微服务远程接口
 * 三个注意事项：
 * 1.使用 @FeignClient注解，声明需要调用的微服务
 * 2.检查RequestMapping注解
 * 3.@PathVariable注解value值不能省略
 */
@FeignClient(value = "microservice-user",fallback = UserControllerImpl.class)
public interface UserController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Integer id);

}
