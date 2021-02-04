package thewind.bytedance;

public class T26MaxPalindrome {
    public void maxPalindrome(String str){
        char[] cs=str.toCharArray();
        int maxLen=1,maxStart=0;
        boolean[][] dp=new boolean[cs.length][cs.length];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<i;j++){
                if(i-j<=2){
                    dp[j][i]=cs[i]==cs[j];
                }else {
                    dp[j][i]=cs[i]==cs[j]&&dp[j+1][i-1];
                }
                if(dp[j][i]&&i-j+1>maxLen){
                    maxLen=i-j+1;
                    maxStart=j;
                }
            }
        }
        String maxStr=str.substring(maxStart,maxLen+maxStart);
        System.out.println(maxStr);
    }
}
