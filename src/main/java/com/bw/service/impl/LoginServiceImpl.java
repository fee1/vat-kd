package com.bw.service.impl;

import com.bw.dao.RolesDao;
import com.bw.dao.TLogonDao;
import com.bw.dao.TYhDao;
import com.bw.model.Roles;
import com.bw.model.RolesExample;
import com.bw.model.TYh;
import com.bw.model.TYhExample;
import com.bw.service.LoginService;
import com.bw.utils.MD5Util;
import com.bw.utils.page.SysPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.ldap.InitialLdapContext;
import java.io.InputStream;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    @Value("${isldap}")
    private String isLdap;

    @Value("${host}")
    private String url;

    @Value("${basedn}")
    private String baseDn;

    private String ldapError;

    @Autowired
    TYhDao tYhDao;
    @Autowired
    RolesDao rolesDao;
    @Autowired
    TLogonDao tLogonDao;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public TYh login(String username, String password){
        try {
            password = MD5Util.generatePassword(password);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        TYhExample example = new TYhExample();
        example.createCriteria().andDlyhidEqualTo(username).andYhmmEqualTo(password);
        List<TYh> tYhs = tYhDao.selectByExample(example);
        if (tYhs == null || tYhs.isEmpty()){
            if (tYhs.size() >1){
                return null;
            }
        }
        TYh tYh = tYhs.get(0);
        //权限 --- 超级用户标志
        boolean flag = true;
        //获取超级用户权限
        String adminRole ;
        try {
            adminRole = SysPara.getValue("adminRole").trim();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        //判断是不是超级用户
        if (tYh.getRoleids().length() > 1){
            for (String id : tYh.getRoleids().split(",")){
                RolesExample rolesExample = new RolesExample();
                rolesExample.createCriteria().andIdEqualTo(Integer.valueOf(id));
                List<Roles> roles = rolesDao.selectByExample(rolesExample);
                if (roles != null && !roles.isEmpty() && roles.get(0).getName().contains(adminRole)){
                    flag = true;
                    break;
                }
            }
        }else if (tYh.getRoleids().length() == 1){
            RolesExample rolesExample = new RolesExample();
            rolesExample.createCriteria().andIdEqualTo(Integer.valueOf(tYh.getRoleids()));
            List<Roles> roles = rolesDao.selectByExample(rolesExample);
            if (roles != null && !roles.isEmpty() && roles.get(0).getName().contains(adminRole)){
                flag = true;
            }
        }
        boolean isSuccess = true;
        if (isLdap.equals("1")){
            if (flag){
                isSuccess = true;
            }else {
                isSuccess = connLDAP(username, password);
            }
        }
        return tYh;
    }

    private final String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";

    public boolean connLDAP(String yhid, String pass){
        boolean connStatus = false;
        baseDn = "";
        Hashtable<String, String> map = new Hashtable<String, String>();
        map.put(Context.INITIAL_CONTEXT_FACTORY, FACTORY);
        map.put(Context.PROVIDER_URL, url+baseDn);
        map.put(Context.SECURITY_CREDENTIALS, pass);
        map.put(Context.SECURITY_AUTHENTICATION, "simple");

        String security = yhid;
        map.put(Context.SECURITY_PRINCIPAL, security);

        DirContext ctx = null;

        try {
            ctx = new InitialLdapContext(map, null);
            connStatus = true;
        }catch (Exception e){
            e.printStackTrace();
            ldapError = e.toString();
        }finally {
            if (ctx != null){
                try {
                    ctx.close();
                }catch (NamingException e){
                    e.printStackTrace();
                }
            }
        }

        TYhExample tYhExample = new TYhExample();
        tYhExample.createCriteria().andDlyhidEqualTo(yhid);
        List<TYh> tYh = tYhDao.selectByExample(tYhExample);
        //插入登录日志
        if (tYh == null || tYh.isEmpty()){

        }
        return connStatus;
    }

}
