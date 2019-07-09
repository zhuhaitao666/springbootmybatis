package com.xxx.springbootmybatis;

import com.xxx.springbootmybatis.redisComponent.RedisComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootmybatisApplicationTests {

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void contextLoads() {

    }
    //需要手动开启服务，尚未设置开机自动启动服务
    @Test
    public void set(){
        redisComponent.set("key","Hello Redis!!!");
    }
    @Test
    public void get()
    {
        System.out.println(redisComponent.get("key"));
    }
    @Test
    public void delete(){
        redisComponent.delete("key");
    }
}
