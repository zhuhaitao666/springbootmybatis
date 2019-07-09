package com.xxx.springbootmybatis.dao;


import com.xxx.springbootmybatis.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MybatisUserDao {
    public User getUser(Integer id);
//  分页测试
    public List<User> getAllUsers();
//  添加更新 用于Redis测试
    public int insertUser(User user);
    public int updateUser(User user);
    public User findUser(Integer id);
    public int deleteUser(Integer id);
}