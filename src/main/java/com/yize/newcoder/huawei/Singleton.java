package com.yize.newcoder.huawei;

//懒汉
//public class Singleton {
//    private static Singleton instance;
//    private Singleton(){
//    }
//
//    private static Singleton getInstance(){
//        if(instance==null){
//            instance=new Singleton();
//        }
//        return instance;
//    }
//}

//饿汉

//public class Singleton {
//    private static Singleton instance=new Singleton();
//    private Singleton(){
//    }
//
//    private static Singleton getInstance(){
//        return instance;
//    }
//}

//双锁检测,原因https://www.cnblogs.com/ALego/p/11448563.html
//public class Singleton {
//    private static volatile Singleton instance;
//    private Singleton(){
//    }
//    private static Singleton getInstance(){
//        if(instance==null){
//            synchronized (Singleton.class){
//                if(instance==null){
//                    instance=new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}

//静态内部类，原理https://blog.csdn.net/mnb65482/article/details/80458571
public class Singleton {
    private Singleton(){
    }
    private static Singleton getInstance(){
        return Inner.singleton;
    }
    private static class Inner{
        public static Singleton singleton=new Singleton();
    }
}



