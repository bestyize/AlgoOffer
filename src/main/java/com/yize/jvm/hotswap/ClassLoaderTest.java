package com.yize.jvm.hotswap;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClassLoader loader=new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is=getClass().getResourceAsStream(fileName);
                if(is==null){
                    super.loadClass(fileName);
                }
                try {
                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException("not found");
                }

            }
        };
        Object obj=loader.loadClass("com.yize.jvm.hotswap.ClassLoaderTest");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.yize.jvm.hotswap.ClassLoaderTest);


    }
    @Test
    public void test() throws Exception {
        Long a;
        System.out.println((a=System.nanoTime())/System.currentTimeMillis());
        Class.forName("com");
        Connection conn=DriverManager.getConnection("");
    }

}
