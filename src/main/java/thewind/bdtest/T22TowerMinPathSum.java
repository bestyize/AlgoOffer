package thewind.bdtest;

import org.junit.Test;

public class T22TowerMinPathSum {

    @Test
    public void test(){
        int[][] tower={{1},{2,3},{4,5,6}};
        System.out.println(minPathSum(tower));
    }

    /**
     * 自底向上的动态规划
     * @param tower
     */
    public int minPathSum(int[][] tower){
        int[]dp=new int[tower[tower.length-1].length];
        for (int layer=tower.length-1;layer>=0;layer--){
            for (int col=0;col<tower[layer].length;col++){
                if(layer==tower.length-1){
                    dp[col]=tower[layer][col];
                }else {
                    dp[col]=Math.min(dp[col],dp[col+1])+tower[layer][col];
                }
            }
        }
        return dp[0];
    }
}
