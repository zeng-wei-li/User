package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    //查单个
    public User getUserById(Integer id);
    //查总数
    public long getCount();

    //分页查
    public List<User> getUserList(Integer size, Integer page);
    //增加
    public void addUser(User user);
    //修改
    public int updateUser(User user);
    //删除
    public int deleteUser(Integer id);
    //
}
