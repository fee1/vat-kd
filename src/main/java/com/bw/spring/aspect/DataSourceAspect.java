package com.bw.spring.aspect;

import com.bw.customannotations.DataSource;
import com.bw.spring.datasource.CustomDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhuxf
 */
@Component
@Aspect
public class DataSourceAspect {

    private final static Logger log = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut(value = "execution(* com.bw.service.ServiceTest.Logon())")
    public void pointCut(){}

    @Before(value = "pointCut()", argNames = "joinPoint")
    public void before(JoinPoint joinPoint){
        try {
            Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
            //判断方法是否存在Datasource注解
            if (method != null && method.isAnnotationPresent(DataSource.class)){
                DataSource dataSource = method.getAnnotation(DataSource.class);
                CustomDataSourceHolder.putDataSource(dataSource.value());
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("数据源切换切面aop异常: {}", e.getMessage());
        }
    }

}
