package com.yize.leetcode;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;

/**
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 * 示例 2：
 *
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 * 示例 3：
 *
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/programmable-robot
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP3 {
    @Test
    public void test(){
        int[][] obs={{5, 5},{9, 4},{9, 7},{6, 4},{7, 0},{9, 5},{10, 7},{1, 1},{7, 5}};
        System.out.println(robot("RRU",obs,1486,743));
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int uN=0,rN=0;
        int [] urN=getUCount(command);
        for(int i=0;i<obstacles.length;i++){
            if((x+y>obstacles[i][0]+obstacles[i][1])&&isOnPath(command,obstacles[i][0],obstacles[i][1],urN,x,y)){
                return false;
            }
        }
        return true;


    }
    public boolean isOnPath(String command,int oX,int oY,int[] urN,int x,int y){
        if(oX>x||oY>y){
            return false;
        }
        int steps=(oX+oY)/command.length();
        int restUR[]=getUCount(command.substring(0,(oX+oY)%command.length()));
        int uStep=urN[0]*steps+restUR[0];
        int rStep=urN[1]*steps+restUR[1];
        if(uStep==oY&&rStep==oX){
            return true;
        }
        return false;
    }

    public int[]getUCount(String command){
        int uN=0,rN=0;
        for(char c:command.toCharArray()){
            if(c=='U'){
                uN++;
            }else {
                rN++;
            }
        }
        return new int[]{uN,rN};
    }


    /**
     * 暴力走完：超时
     * @param command
     * @param obstacles
     * @param x
     * @param y
     * @return
     */
    public boolean method1(String command, int[][] obstacles, int x, int y) {
        HashMap<String,Integer> map=new HashMap();
        for(int []i:obstacles){
            map.put(i[0]+""+i[1],1);
        }
        int ptr=0;
        int currentPos[]=new int[]{0,0};
        while(currentPos[0]<=x&&currentPos[1]<=y){
            if(ptr==command.length()){
                ptr=0;
            }
            if(x==currentPos[0]&&y==currentPos[1]){
                return true;
            }
            if(map.containsKey(currentPos[0]+""+currentPos[1])){
                return false;
            }
            char c=command.charAt(ptr++);
            if(c=='R'){
                currentPos[0]++;
            }else {
                currentPos[1]++;
            }
        }
        return false;
    }
}
