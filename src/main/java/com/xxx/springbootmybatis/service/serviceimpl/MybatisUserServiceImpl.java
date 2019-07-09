package com.xxx.springbootmybatis.service.serviceimpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.springbootmybatis.bean.User;
import com.xxx.springbootmybatis.dao.MybatisUserDao;
import com.xxx.springbootmybatis.service.MybatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MybatisUserServiceImpl implements MybatisUserService {

    @Autowired
    private MybatisUserDao mybatisUserDao;
    //集成Mybatis测试
    @Override
    @Transactional
    public User getUser(Integer id) {
        return mybatisUserDao.findUser(id);
    }

    @Override
    // page表示当前页数，pageSize表示当前页数
    public PageInfo<User> getAllUsers(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);//底层会帮我们使用limit改写语句
        List<User>users=mybatisUserDao.getAllUsers();
        //返回给客户端展示
        PageInfo<User> pageInfo=new PageInfo<User>(users);//务必加入得到的users信息
        return pageInfo;
    }

    @Override
    public List<User> getAllUsers() {
        List<User>users=mybatisUserDao.getAllUsers();
        return users;
    }
    //插入用户，最后Mybatis会回填ID,取结果id缓存用户
    @Override
    @Transactional
    @CachePut(value = "redisCache",key = "'redis_user_'+#result.id")
    //当方法返回值为int类型时会报找不到id异常
    //value配置对应缓存名称redisCache 键配置：#result表示返回对象user
    //而且返回类型必须为User不然会报异常
    public User insertUser(User user) {
         mybatisUserDao.insertUser(user);
         return user;
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache",key = "'redis_user_'+#result.id",condition = "#result!='null'")
    //如果返回结果为空，则不使用缓存
    public User updateUser(Integer id,String name) {
        User user=this.findUser(id);//该方法的缓存注解在此处会失效
        if(user==null)
        {
            System.out.println("查找用户失败!!!");
            return null;
        }
        user.setName("更改后的名字");
        user.setNote("更改后的身份");
        mybatisUserDao.updateUser(user);//不要忘了。。
        return user;
    }

    @Override
    @Transactional
    @Cacheable(value = "redisCache" ,key = "'redis_user_'+#id")
    //参数中不是User对象不能设置为#result.id
    public User findUser(Integer id) {
        return mybatisUserDao.findUser(id);
    }

    @Override
    @Transactional
    @CacheEvict(value = "redisCache",key ="'redis_user_'+#id",beforeInvocation = false)
    //默认值为false 表示在该方法之后移除缓存
    public int deleteUser(Integer id) {
        return mybatisUserDao.deleteUser(id);
    }


}
