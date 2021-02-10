package thewind.bdtest;

public class T15CoinChange {
    public int coinChange(int amount,int[] coins){
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int coin:coins){
            for (int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}
