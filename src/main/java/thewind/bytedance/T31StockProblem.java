package thewind.bytedance;

/**
 * 买卖股票问题
 */
public class T31StockProblem {
    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    public int maxProfit(int[] prices) {
        int maxProfit=0,min=prices[0];
        for (int p:prices){
            min=Math.min(p,min);
            maxProfit=Math.max(maxProfit,p-min);
        }
        return maxProfit;
    }

    public int maxProfitII(int[] prices) {
        int maxProfit=0,min=prices[0];
        for (int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }

        }
        return maxProfit;
    }


    /**
     * 123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     *
     * 示例 1:
     *
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     * 示例 4：
     *
     * 输入：prices = [1]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 105
     */

    public int maxProfitIII(int[] prices){
        int[] dpLeft=new int[prices.length];
        int leftMin=prices[0];
        int leftMaxProfit=0;
        for (int i=1;i<prices.length;i++){
            leftMin=Math.min(leftMin,prices[i]);
            leftMaxProfit=Math.max(leftMaxProfit,prices[i]-leftMin);
            dpLeft[i]=leftMaxProfit;
        }

        int[] dpRight=new int[prices.length];
        int rightMax=prices[prices.length-1];
        int rightMaxProfit=0;
        for (int i=prices.length-2;i>=0;i--){
            rightMax=Math.max(rightMax,prices[i]);
            rightMaxProfit=Math.max(rightMax-prices[i],rightMaxProfit);
            dpRight[i]=rightMaxProfit;
        }
        int maxProfit=0;
        for (int i=0;i<dpLeft.length;i++){
            maxProfit=Math.max(maxProfit,dpLeft[i]+dpRight[i]);
        }
        return maxProfit;
    }
}
