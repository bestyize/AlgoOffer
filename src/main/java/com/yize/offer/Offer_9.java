package com.yize.offer;

public class Offer_9 {
    public int JumpFloorII(int target) {
        int prev=1;
        int result=1;
        for(int i=1;i<target;i++){
            result=prev*2;
            prev=result;
        }
        return result;
    }
}
