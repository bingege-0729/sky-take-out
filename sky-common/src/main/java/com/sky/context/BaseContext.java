package com.sky.context;

public class BaseContext {

    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    //线程绑定的变量，存放当前登录用户id
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
    //获取当前登录用户id
    public static Long getCurrentId() {
        return threadLocal.get();
    }
    //移除当前登录用户id
    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
