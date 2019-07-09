package com.xxx.springbootmybatis;

import com.xxx.springbootmybatis.filter.MyFilter;
import com.xxx.springbootmybatis.listener.MyListener;
import com.xxx.springbootmybatis.servlet.StudentServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.xxx.springbootmybatis.controller","com.xxx.springbootmybatis.service"})
//@EnableAutoConfiguration
// 使用该扫包优化  4.46vs4.58
@MapperScan(basePackages = "com.xxx.springbootmybatis.*",
//        sqlSessionFactoryRef = "sqlSessionFactory",
////        sqlSessionTemplateRef = "sqlSessionTemplate",
         annotationClass = Repository.class) //扫描的mapper
@EnableAsync//允许异步调用
@EnableCaching//启动缓存机制
public class SpringbootmybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootmybatisApplication.class, args);
    }
/*  @Bean 集成Serlvet Filter Listener
    public ServletRegistrationBean getServlet(){
        return new ServletRegistrationBean(new StudentServlet(),"/servlet");
    }
    @Bean
    public FilterRegistrationBean getFilter(){
        return new FilterRegistrationBean(new MyFilter(),getServlet());//可以添加多个servlet
    }
    @Bean
    public ServletListenerRegistrationBean<MyListener> getListener(){
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
*/


}
