package thewind.note;

/**
 * 双检锁
 */
public class Singleton {
    public volatile static Singleton singleton;//防止指令重排序
    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton==null){//避免不必要的加锁
            synchronized (Singleton.class){//多线程访问控制，
                if(singleton==null){//防止重复创建instance
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

}

/**
 * 饱汉式
 */
class SingletonEat{
    public static SingletonEat instance;
    private SingletonEat(){}
    public static SingletonEat getInstance(){
        if(instance==null){
            instance=new SingletonEat();
        }
        return instance;
    }
}

/**
 * 饿汉式
 */
class SingletonHungry{
    public static SingletonHungry instance=new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance(){
        return instance;
    }
}

/**
 * 静态内部类单例模式 。
 */
class SingletonInner{
    private SingletonInner(){}
    public static SingletonInner getInstance(){
        return Inner.inner;
    }

    private static class Inner{
        public static final SingletonInner inner=new SingletonInner();
    }
}

