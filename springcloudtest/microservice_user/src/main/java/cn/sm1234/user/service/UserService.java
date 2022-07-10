package cn.sm1234.user.service;

import cn.sm1234.user.dao.UserDao;
import cn.sm1234.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户service
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(Integer id){
        return userDao.findById(id).get();
    }

    public void add(User user){
        System.out.println(user.getUsername());
        userDao.save(user);
    }

    public void update(User user){
        userDao.save(user);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }
}
