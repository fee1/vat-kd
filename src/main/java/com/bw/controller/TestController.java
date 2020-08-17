package com.bw.controller;

import com.bw.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ServiceTest serviceTest;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String testController(){
        return "Hello World";
    }

    @ResponseBody
    @RequestMapping(value = "testDatabase", method = RequestMethod.GET)
    public String testDatabaseConn(){
        return serviceTest.Logon();
    }

}
