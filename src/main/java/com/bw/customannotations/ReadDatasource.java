package com.bw.customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuxf
 * 读写分离的第一种方式的注解类
 * 通过类或者方法上的注解区分使用那个数据源，注意不要在mapper接口类使用，主从数据库的同步存在延迟，在mapper上可能会导致数据的不一致
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadDatasource {
}
