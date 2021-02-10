package thewind.bdtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class T17RemoveListElement {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator=list.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(123)){
                iterator.remove();
            }
        }
        for (Integer i:list){
            System.out.println(i);
        }
    }
}
