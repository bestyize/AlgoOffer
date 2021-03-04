package thewind.bdtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
//https://blog.csdn.net/PanPa_WoNiu/article/details/81185178
public class T17RemoveListElement {
    @Test
    public void test0(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (String i:list){
            list.remove(i);
        }
        for (String i:list){
            System.out.print(i+" ");
        }
    }

    @Test
    public void test1(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (int i=0;i<list.size();i++){
            list.remove(i);
        }
        for (String i:list){
            System.out.print(i+" ");
        }
    }

    @Test
    public void test2() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator=list.listIterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
//            if(iterator.next().equals(2)){
//                iterator.remove();
//            }
        }
        for (Integer i:list){
            System.out.println(i);
        }
    }
    @Test
    public void test3(){
        List<Integer> list=new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer i:list){
            list.remove(i);
//            if(i==2){
//                list.remove(i);
//            }
        }
        for (Integer i:list){
            System.out.print(i+" ");
        }
    }
}
