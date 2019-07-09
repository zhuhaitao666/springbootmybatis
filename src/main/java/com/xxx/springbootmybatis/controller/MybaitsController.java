package com.xxx.springbootmybatis.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.springbootmybatis.bean.User;
import com.xxx.springbootmybatis.service.MybatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/mybatis")
public class MybaitsController {

    @Autowired
    private MybatisUserService mybatisUserService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Integer id){
        return mybatisUserService.getUser(id);
    }

    @RequestMapping("/getAllUsers")
    public String getAllUsers(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<User> list = mybatisUserService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<User>(list);

        System.out.println("当前页数:"+pageInfo.getPageNum());
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        for (User user:list) {
            System.out.println("学生姓名:"+user.getName());
        }
        model.addAttribute("users",list);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }

    @RequestMapping("/index")
    @ResponseBody//返回JSON格式的用户分页信息
    public PageInfo<User> getAllUsers(int page,int pageSize){
        return mybatisUserService.getAllUsers(page,pageSize);
    }
}
