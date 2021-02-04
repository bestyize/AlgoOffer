package thewind.bytedance;

import org.junit.Test;

import java.util.*;
//https://www.cnblogs.com/goody9807/p/6432904.html
public class T17RemoveListElement {
    @Test
    public void removeListElement(){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println(list);
        ListIterator<Integer> it=list.listIterator();
        while (it.hasNext()){
            if(it.next().equals(2)){
                it.remove();//为什么用了迭代码器就不能采用famous.remove(s)操作? 这种因为ArrayList与Iterator混合使用时会导致各自的状态出现不一样，最终出现异常。
            }
        }
        System.out.println(list);;
    }
}
