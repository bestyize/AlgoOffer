package thewind.note;

public class Test {
    @org.junit.Test
    public void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
            }
        }).start();
    }

    public int coinChange(int amount,int[] coins){
        int[] dp=new int[amount+1];
        dp[0]=1;//兑换为0只有1种方法，即不兑换
        for (int coin:coins){
            for (int x=coin;x<=amount;x++){
                dp[x]+=dp[x-coin];
            }
        }
        return dp[amount];
    }
}
