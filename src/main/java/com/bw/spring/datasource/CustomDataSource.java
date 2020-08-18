package com.bw.spring.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.ReflectionUtils;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuxf
 */
public class CustomDataSource extends AbstractRoutingDataSource {

    private Integer countSlave;

    @Override
    protected Object determineCurrentLookupKey() {
        return CustomDataSourceHolder.getDataSourceKey();
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        Field field = ReflectionUtils.findField(AbstractRoutingDataSource.class, "resolvedDataSources");
        field.setAccessible(true);
        try {
            Map<Object, DataSource> resolvedDataSources = (Map<Object, DataSource>) field.get(this);
            //获取从数据库的数量
            countSlave = resolvedDataSources.size() - 1;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
