package com.yize.jvm;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Chapter07 {
    public static void main(String[] args) throws Exception{

        ClassLoader myLoader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is=getClass().getResourceAsStream(fileName);
                if(is==null){
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException("未发现");
                }

            }
        };

        Object obj=myLoader.loadClass("com.yize.jvm.Chapter07").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.yize.jvm.Chapter07);
    }

    private void test(){
        Character c=new Character('2');
        ClassLoader loader=this.getClass().getClassLoader();
        System.out.println("Test");
    }
}
