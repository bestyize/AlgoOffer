package com.yize.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Observer{
    void update(String msg);
}

class ObserverOne implements Observer{
    public ObserverOne(Subject subject) {
        subject.attach(this);
    }
    @Override
    public void update(String msg) {
        System.out.println(this.getClass().getName()+"接收到消息："+msg);
    }
}

class ObserverTwo implements Observer{
    public ObserverTwo(Subject subject) {
        subject.attach(this);
    }
    @Override
    public void update(String msg) {
        System.out.println(this.getClass().getName()+"接收到消息："+msg);
    }
}
class Subject{
    private List<Observer> observerList;
    public Subject() {
        this.observerList = new ArrayList<>();
    }
    public void attach(Observer observer){
        this.observerList.add(observer);
    }
    public void setState(String msg){
        for (Observer observer:observerList){
            observer.update(msg);
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject=new Subject();
        Observer observer1=new ObserverOne(subject);
        Observer observer2=new ObserverTwo(subject);
        subject.setState("广播消息");
    }
}
