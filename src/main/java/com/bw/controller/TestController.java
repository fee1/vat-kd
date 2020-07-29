package com.bw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试springmvc情况
 * @author zxf
 * @date 2020/07/21
 */
@Controller
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String testController(){
        return "Hello World";
    }

}
