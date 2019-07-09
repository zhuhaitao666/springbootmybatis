package com.xxx.springbootmybatis.controller;

import com.xxx.springbootmybatis.bean.User;
import com.xxx.springbootmybatis.service.MybatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String,Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1","value1");
        //默认使用JDK的序列化器，所以Redis保存的不是整数，不能进行运行
        redisTemplate.opsForValue().set("int_key1","1");
        //使用运算
        stringRedisTemplate.opsForValue().set("int","1");
        //获取底层Redis连接
//        RedisProperties.Jedis jedis;
//        jedis= (RedisProperties.Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
//        jedis.

        //减一操作 redisTemplate不支持
        Map<String,String> hash=new HashMap();
        hash.put("field1","value1");
        hash.put("field2","value2");
        //存入一个散列数据类形
        stringRedisTemplate.opsForHash().putAll("hash",hash);
        stringRedisTemplate.opsForHash().put("hash","field3","value3");
        //绑定散列操作的key，这样可以连续对一个散列数据类型进行操作
        BoundHashOperations hashOps=  stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1","field2");
        hashOps.put("field4","value4");
        Map map=new HashMap();
        map.put("Success",true);
        return map;
    }


    @Autowired
    private MybatisUserService mybatisUserService;
    @RequestMapping("/insertUser")
    @ResponseBody
    public User insertUser(){
        User user=new User();
        user.setName("redis");
        user.setNote("新成员");
        mybatisUserService.insertUser(user);
        return user;
    }
    @RequestMapping("/findUser")
    @ResponseBody
    public User findUser(int id)
    {
        return mybatisUserService.findUser(id);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public User updateUser(Integer id,String name){
        return mybatisUserService.updateUser(id,name);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(Integer id){
         return mybatisUserService.deleteUser(id);
    }
}
