package thewind.note;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void handleMessage(String msg);
}

class ObserverOne implements Observer{
    public ObserverOne(Subject subject) {
        subject.subscribe(this);
    }

    @Override
    public void handleMessage(String msg) {
        System.out.println(this.getClass().getName()+":"+msg);
    }
}

class ObserverTwo implements Observer{
    public ObserverTwo(Subject subject) {
        subject.subscribe(this);
    }
    @Override
    public void handleMessage(String msg) {
        System.out.println(this.getClass().getName()+":"+msg);
    }
}


class Subject{
    private List<Observer> observerList;

    public Subject() {
        observerList=new ArrayList<>();
    }

    public void subscribe(Observer observer){
        this.observerList.add(observer);
    }

    public void unSubscribe(Observer observer){
        this.observerList.remove(observer);
    }

    public void boardcast(String msg){
        for (Observer observer:observerList){
            observer.handleMessage(msg);
        }
    }

}
public class ObserverMode {
    public static void main(String[] args) {
        Subject subject=new Subject();
        Observer observer=new ObserverOne(subject);
        Observer observer1=new ObserverTwo(subject);
        subject.boardcast("123");

    }
}
