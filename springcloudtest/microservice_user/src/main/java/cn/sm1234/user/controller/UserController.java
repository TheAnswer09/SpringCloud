package cn.sm1234.user.controller;

import cn.sm1234.user.pojo.User;
import cn.sm1234.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Controller
 */
@RequestMapping("/user")
@RestController   // @RestController = @RequestMapping + @ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        // 模拟用户数据
//        List<User> list = new ArrayList<>();
//        list.add(new User(1,"张三","123456","男",1000.0));
//        list.add(new User(2,"李三","123456","男",1000.0));
//        list.add(new User(3,"王三","123456","男",1000.0));
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Integer id){
        System.out.println("查询用户2222");
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user){
        userService.add(user);
        return "添加成功";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@RequestBody User user, @PathVariable Integer id){
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return "删除成功";
    }
}
