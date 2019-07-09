package com.xxx.springbootmybatis.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("user")
public class User implements Serializable {

//    @Value("1")
    private Integer id;
//    @Value("朱海涛")
    private String name;
//    @Value("一个平凡的人")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
