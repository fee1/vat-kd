package com.bw.customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuxf
 * 读写分离的第一种方式的注解类
 * 通过类或者方法上的注解区分使用那个数据源，主要使用在mapper接口类
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadDatasource {
}
