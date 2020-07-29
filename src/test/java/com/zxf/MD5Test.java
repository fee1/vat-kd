package com.zxf;

import com.bw.config.ApplicationContextService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MD5Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextService.class);
        com.bw.service.ServiceTest serviceTest = (com.bw.service.ServiceTest) context.getBean("serviceTest");
        serviceTest.test();
    }

}
