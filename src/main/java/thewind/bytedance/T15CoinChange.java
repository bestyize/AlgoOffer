package thewind.bytedance;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * 通过次数39,097提交次数69,299
 */
public class T15CoinChange {
    /**
     * 和爬楼梯问题非常相似
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int coin:coins){
            for (int x=coin;x<=amount;x++){
                dp[x]+=dp[x-coin];
            }
        }
        return dp[amount];
    }

    @Test
    public void test(){
        int amount=6;
        int steps[]={1,2,5};
        System.out.println(change(amount,steps));
        System.out.println(staff(amount));
    }

    /**衍生问题
     * 算法题---n阶，每次只能走1，2，5个阶梯，到达n阶有几种方法,使用常数空间
     *
     * 1 2 3 4 5
     */

    public int staff(int n){
        int[] dp={1,2,2,4,5};
        int step[]={1,2,0,0,5};
        for (int i=5;i<=n;i++){
            dp[i%5]=dp[(i-1)%5]+step[(i-1)%5]+step[(i-2)%5]+step[(i-5)%5];
        }
        return dp[(n-1)%5];
    }
}
