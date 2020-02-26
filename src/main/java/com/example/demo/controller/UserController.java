package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("用户接口模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;



    //查单个
    @ApiOperation(value = "查单个用户接口",notes = "查单个接口",httpMethod = "GET")
    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)

    public String getUserById(
            @ApiParam(name="id",value = "用户id",required = true)
            Integer id){
        return JSON.toJSONString(userService.getUserById(id));
    }
    //查总数
    @ApiOperation(value = "查用户总数",notes = "查用户总数",httpMethod = "GET")
    @RequestMapping(value = "/getCount",method = RequestMethod.GET)
    public long getCount(){
        return userService.getCount();
    }

    //分页查询
    @ApiOperation(value = "分页查询用户",notes = "分页查询用户",httpMethod = "GET")
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public String getUserList(
            @ApiParam(name="size",value = "每页多少条",required = true,defaultValue ="5" )
            @RequestParam(name="size",defaultValue = "5") Integer size,
            @ApiParam(name="page",value = "第几页",required = true,defaultValue ="1" )
            @RequestParam(name="page",defaultValue = "1") Integer page){
        return JSON.toJSONString(userService.getUserList(size,page));
    }
    //增加
    @ApiOperation(value = "用户添加接口",notes = "用户添加接口",httpMethod = "PUT")
    @RequestMapping(value = "/addUser",method = RequestMethod.PUT)
    public void addUser(
            @ApiParam(name="user",value = "用户实体类",required = true)
            @RequestBody User user){ userService.addUser(user);
    }
    //修改
    @ApiOperation(value = "用户修改接口",notes = "用户修改接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(
            @ApiParam(name="user",value = "用户实体类",required = true)
            @RequestBody User user){
        return userService.updateUser(user);
    }


    //删除
    @ApiOperation(value = "删除一个用户接口",notes = "删除一个用户接口",httpMethod = "DELETE")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public int deleteUser(
            @ApiParam(name="id",value = "用户id",required = true)
            @RequestParam(name="id")Integer id){
       return userService.deleteUser(id);
    }


}
