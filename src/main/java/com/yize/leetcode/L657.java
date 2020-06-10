package com.yize.leetcode;

public class L657 {
    public boolean judgeCircle(String moves) {
        char cs[]=moves.toCharArray();
        int profitX=0;
        int profitY=0;
        for(char c:cs){
            if(c=='R'){
                profitX++;
            }else if(c=='L'){
                profitX--;
            }else if(c=='U'){
                profitY++;
            }else{
                profitY--;
            }
        }
        return profitY==0&&profitX==0;
    }
}
