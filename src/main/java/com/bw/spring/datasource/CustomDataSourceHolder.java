package com.bw.spring.datasource;

/**
 * @author zhuxf
 */
public class CustomDataSourceHolder {

    private final static ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name){
        holder.set(name);
    }

    public static String getDataSource(){
        return holder.get();
    }

}
