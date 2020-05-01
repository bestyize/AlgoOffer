package com.yize.offer;

public class Offer_8 {
    public int JumpFloor(int target) {
        int prev=1,prevPrev=0;
        int result=prev+prevPrev;
        for(int i=1;i<=target;i++){
            result=prev+prevPrev;
            prevPrev=prev;
            prev=result;
        }
        return result;
    }
}
