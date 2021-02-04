package thewind.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class T27MergerInterval {
    public void mergerInterval(int[][] intervals){
        Arrays.sort(intervals,(o1,o2)->o2[0]-o1[0]);
        List<int[]> list=new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            if(!list.isEmpty()&&intervals[i][0]>list.get(list.size()-1)[1]){
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }else {
                list.add(intervals[i]);
            }
        }
        for (int[] i:list){
            System.out.println(i[0]+" "+i[1]);
        }

    }
}
