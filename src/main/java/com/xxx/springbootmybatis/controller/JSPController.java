package com.xxx.springbootmybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JSPController {
    @RequestMapping("/index")
    public String test(){
        return "index";
    }
}
