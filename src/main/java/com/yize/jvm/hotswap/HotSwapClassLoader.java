package com.yize.jvm.hotswap;

public class HotSwapClassLoader extends ClassLoader{
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    /**
     * 公开java.lang.Classloader中的defineClass方法
     * 使用这个方法把提交执行的Java类的byte[]数组变为Class对象
     * @param classByte
     * @return
     */
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }

}
