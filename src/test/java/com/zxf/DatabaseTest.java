package com.zxf;

import com.alibaba.fastjson.JSON;
import com.bw.customannotations.DatasourceRead;
import com.bw.customannotations.DatasourceWrite;
import com.bw.dao.AdminActivitiesDao;
import com.bw.dao.TLogonDao;
import com.bw.model.AdminActivities;
import com.bw.model.AdminActivitiesExample;
import com.bw.model.TLogon;
import com.bw.model.TLogonExample;
import com.bw.service.LoginService;
import com.bw.service.ServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 测试mybatis与spring整合情况
 * @author zxf
 * @date 2020/07/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application-*.xml"})
public class DatabaseTest {

    @Autowired
    private AdminActivitiesDao adminActivitiesDao;

    @Autowired
    private ServiceTest serviceTest;

    /**
     * 测试数据库配置链接是否成功
     */
    @Test
    public void databaseTest(){
        System.out.println(adminActivitiesDao == null);
        AdminActivitiesExample example = new AdminActivitiesExample();
        example.createCriteria().andIdEqualTo(1L);
        List<AdminActivities> adminActivities = adminActivitiesDao.selectByExample(example);
        System.out.println(adminActivities.toString());
    }

    /**
     * 测试读写分离，读库操作是否成功
     */
    @Test
    public void testDatabaseRead(){
        System.out.println(serviceTest.Logon());
    }

}