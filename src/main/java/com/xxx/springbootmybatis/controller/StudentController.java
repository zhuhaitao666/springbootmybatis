package com.xxx.springbootmybatis.controller;


import com.xxx.springbootmybatis.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("str","Hello SpringBoot FreeMarker Test");
        Student student=new Student();
        student.setId(1);
        student.setName("小芳");
        model.addAttribute("stu",student);
        //集合测试
        List<Student> students=new ArrayList();
        for(int i=1;i<=3;i++)
        {
            Student s=new Student();
            s.setName("学生"+i);
            s.setId(i);
            students.add(s);
        }
        model.addAttribute("students",students);
        //返回show模板
        return "show";
    }
    @RequestMapping("/testThymeleaf")
    public String show1(Model model)
    {
        model.addAttribute("str","Hello SpringBoot Thymeleaf Test");
        Student student=new Student();
        student.setId(1);
        student.setName("小芳");
        model.addAttribute("stu",student);
        //集合测试
        List<Student> students=new ArrayList();
        for(int i=0;i<3;i++)
        {
            Student s=new Student();
            s.setName("学生"+i);
            s.setId(i);
            students.add(s);
        }
        model.addAttribute("students",students);
        return "showThymeleaf";
    }
}
