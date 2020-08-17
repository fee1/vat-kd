package com.zxf;

import com.bw.config.ApplicationContextService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试全注解形式的形式
 * @author zxf
 * @date 2020/07/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application-*.xml"})
public class ServiceTest {

    @Autowired
    com.bw.service.ServiceTest serviceTest;

    @Test
    public void testService(){
        serviceTest.test();
    }


}
