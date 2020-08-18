package com.bw.spring.datasource;

/**
 * @author zhuxf
 */
public class CustomDataSourceHolder {

    private final static ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSourceKey(String name){
        holder.set(name);
    }

    public static String getDataSourceKey(){
        return holder.get();
    }

}
