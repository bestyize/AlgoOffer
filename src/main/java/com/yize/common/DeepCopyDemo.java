package com.yize.common;

import org.junit.Test;

import java.io.*;

public class DeepCopyDemo implements Serializable{
    class Book implements Serializable{
        private String name;
        private int id;

        public Book(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"name\":\"" + name + "\"" +
                    ", \"id\":\"" + id + "\"" +
                    "}";
        }
    }

    class Student implements Serializable{
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"name\":\"" + name + "\"" +
                    ", \"id\":\"" + id + "\"" +
                    "}";
        }
    }

    class School implements Cloneable,Serializable{
        private int id;
        private String name;
        private Book book;
        private Student student;

        public School(int id, String name, Book book, Student student) {
            this.id = id;
            this.name = name;
            this.book = book;
            this.student = student;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"id\":\"" + id + "\"" +
                    ", \"name\":\"" + name + "\"" +
                    ", \"book\":\"" + book + "\"" +
                    ", \"student\":\"" + student + "\"" +
                    "}";
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }


        public Object deepClone() throws IOException, ClassNotFoundException {
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(bos);
            objectOutputStream.writeObject(this);

            ObjectInputStream objectInputStream=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            return objectInputStream.readObject();

        }
    }
    @Test
    public void test() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Book book=new Book("百年孤独",1);
        Student student=new Student("亦泽",1);
        School school=new School(1,"一中",book,student);
        System.out.println("原对象："+school.toString());
        //默认浅拷贝
        School school1=(School)school.clone();
        //利用序列化实现深拷贝
        School school2=(School)school.deepClone();

        school1.getBook().setId(10086);
        school1.setId(100);
        System.out.println("浅拷贝对象："+school1.toString());

        System.out.println("修改浅拷贝后原对象："+school.toString());
        System.out.println("深拷贝对象对象："+school2.toString());
        StringBuilder sb=new StringBuilder();

    }
}
