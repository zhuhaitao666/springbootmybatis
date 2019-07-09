package com.xxx.springbootmybatis.redisComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisComponent {
    //通过stringRedisTemplate进行序列化键值，这样只能支持支持字符串，并不能支持java对象的储存。
    //不设置时，RedisTemplate默认使用JdkSerializationRedisSerializer 进行序列化键值。存储到
    //服务器，这是存入的便是一个经过序列化后的特殊字符，对于我们跟踪不友好！
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key,String value){
        //拿到存储操作对象
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key))
        {
            System.out.println("Key="+key+"value="+value);
        }
        else{
            ops.set(key, value);
            System.out.println("添加成功!");
        }
    }
    public String get(String key){

        return stringRedisTemplate.opsForValue().get(key);
    }
    public void delete(String key){
        stringRedisTemplate.delete(key);
        System.out.println("删除成功！");
    }

}
