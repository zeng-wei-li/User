package com.example.demo.service.impl;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        System.out.println(userDao);
        return  userDao.unique(id);

    }

    @Override
    public long getCount() {
        return userDao.allCount();
    }

    @Override
    public List<User> getUserList(Integer size, Integer page) {
        if(page==null||page<1){
            page=1;
        }
        if(size==null||size<0){
            size=5;
        }
        System.out.println(page);
        int start=(page-1)*size+1;
        System.out.println("start:"+start);
        return  userDao.all(start,size);
    }

    @Override
    public void addUser(User user) {
         userDao.insert(user,true);
    }

    @Override
    public int updateUser(User user) {
       return userDao.updateById(user);
    }

    @Override
    public int deleteUser(Integer id) {
       return userDao.deleteById(id);
    }
}
