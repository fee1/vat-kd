package com.bw.service;

import com.alibaba.fastjson.JSON;
import com.bw.customannotations.DataSource;
import com.bw.dao.TLogonDao;
import com.bw.model.TLogon;
import com.bw.model.TLogonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service层测试类
 * @author zxf
 * @date 2020/07/22
 */
@Service
public class ServiceTest {

    @Autowired
    TLogonDao tLogonDao;

    public void test(){
        System.out.println("hello world");
    }

    @DataSource("master")
    public String Logon() {
        TLogonExample tLogonExample = new TLogonExample();
        tLogonExample.createCriteria().andLogonIdEqualTo(86729L);
        List<TLogon> tLogonList = tLogonDao.selectByExample(tLogonExample);
        return JSON.toJSONString(tLogonList);
    }

}
