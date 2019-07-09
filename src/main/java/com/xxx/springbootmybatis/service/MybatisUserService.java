package com.xxx.springbootmybatis.service;

import com.github.pagehelper.PageInfo;
import com.xxx.springbootmybatis.bean.User;

import java.util.List;

public interface MybatisUserService {
    public User getUser(Integer id);
    public PageInfo<User> getAllUsers(int page, int pageSize);//JSON格式分页测试
    public List<User> getAllUsers();
    //   用于Redis测试
    public User insertUser(User user);
    public User updateUser(Integer id,String name);
    public User findUser(Integer id);
    public int deleteUser(Integer id);
}
