package com.yize.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 源自更新引用类
 */
public class AtomicReferenceTest {

    public static AtomicReference<User> userAtomicReference=new AtomicReference<>();

    public static void main(String[] args) {
        User user=new User("zhang",11);
        userAtomicReference.set(user);
        User updateUser=new User("张",22);
        userAtomicReference.compareAndSet(user,updateUser);
        System.out.println(userAtomicReference.get().getName());
    }

    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
