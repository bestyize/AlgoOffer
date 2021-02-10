package thewind.bdtest;

import java.util.ArrayList;
import java.util.Arrays;

public class T8ArrayList<T> {
    private Object[] element;
    private int size;

    public T8ArrayList() {
        element=new Object[16];
        size=0;
    }

    public void add(T t){
        ensureCap();
        element[size++]=t;
    }

    public T remove(T t){
        for (int i=0;i<size;i++){
            if(element[i]==t){
                return remove(i);
            }
        }
        return null;
    }

    private T remove(int index){
        if(index>=size){
            return null;
        }
        Object t=element[index];
        while (index<size){
            element[index]=element[index+1];
            index++;
        }
        return (T)t;
    }

    public void ensureCap(){
        if(size==element.length){
            Object[] temp=new Object[size+size>>1];
            System.arraycopy(element,0,temp,0,size);
            element=temp;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
