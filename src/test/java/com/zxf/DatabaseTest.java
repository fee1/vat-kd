package com.zxf;

import com.bw.dao.AdminActivitiesDao;
import com.bw.model.AdminActivities;
import com.bw.model.AdminActivitiesExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试mybatis与spring整合情况
 * @author zxf
 * @date 2020/07/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:application-*.xml"})
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class DatabaseTest {

    @Autowired
    AdminActivitiesDao adminActivitiesDao;

    @Test
    public void databaseTest(){
        System.out.println(adminActivitiesDao == null);
        AdminActivitiesExample example = new AdminActivitiesExample();
        example.createCriteria().andIdEqualTo(1L);
        List<AdminActivities> adminActivities = adminActivitiesDao.selectByExample(example);
        System.out.println(adminActivities.toString());
    }

}
