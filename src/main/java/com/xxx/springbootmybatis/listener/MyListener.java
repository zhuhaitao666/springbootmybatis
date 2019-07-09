package com.xxx.springbootmybatis.listener;



import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session对象被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session对象被销毁");
    }
}
