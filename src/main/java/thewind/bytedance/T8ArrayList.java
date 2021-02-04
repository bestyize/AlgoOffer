package thewind.bytedance;

import java.util.Arrays;

public class T8ArrayList {
    private Object[] element;
    private int size;

    public T8ArrayList() {
    }

    public T8ArrayList(int cap){
        if(cap<0){
            return;
        }
        element=new Object[cap];
    }

    public void add(Object obj){
        add(obj,size);
    }

    public void add(Object obj,int index){
        ensureCap();
        if(index>=element.length){
            return;
        }
        element[size++]=obj;
    }

    public Object remove(Object obj){
        for (int i=0;i<element.length;i++){
            if(obj==element[i]){
                return remove(i);
            }
        }
        return null;
    }

    public Object remove(int index){
        if(index>=size){
            return null;
        }
        Object e=element[index];
        while (index<size){
            element[index]=element[++index];
        }
        return e;
    }

    private void ensureCap(){
        if(size==element.length){
            Object[] newArr=new Object[size*2+1];
            System.arraycopy(element,0,newArr,0,size);
            element=newArr;
        }
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

}
