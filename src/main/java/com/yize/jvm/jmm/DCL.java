package com.yize.jvm.jmm;

/**
 * 双锁   检测实现单例模式
 */
public class DCL {
    private static volatile DCL instance;
    private DCL(){}
    public static DCL getInstance(){
        if(instance==null){
            synchronized (DCL.class){
                if(instance==null){
                    instance=new DCL();
                }
            }
        }
        return instance;
    }
}
