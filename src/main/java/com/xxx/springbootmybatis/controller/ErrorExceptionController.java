package com.xxx.springbootmybatis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


//@ControllerAdvice
//public class ErrorExceptionController {
//    private static final Logger log=  LoggerFactory.getLogger(ErrorExceptionController.class);
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView proessException(Exception e){
//        ModelAndView m=new ModelAndView();
//        m.addObject("info","出现了Exception异常");
//        m.setViewName("error");
//        return m;
//    }
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView proessException(RuntimeException e){
//        ModelAndView m=new ModelAndView();
//        m.addObject("info","出现了RuntimeException异常");
//        m.setViewName("error");
//        return m;
//    }
//}
