package com.bw.spring.datasource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuxf
 */
public class CustomDataSourceHolder {

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);

    private final static ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSourceKey(String name){
        holder.set(name);
    }

    public static String getDataSourceKey(){
        return holder.get();
    }

    public static int getAtomicInteger(){
        return atomicInteger.getAndAdd(1);
    }

    public static void setAtomicInteger(){
        atomicInteger.set(0);
    }

}