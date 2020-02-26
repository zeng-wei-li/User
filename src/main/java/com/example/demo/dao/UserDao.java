package com.example.demo.dao;

import com.example.demo.entity.User;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

@SqlResource("user")
public interface UserDao extends BaseMapper<User> {



}
