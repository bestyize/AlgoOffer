package thewind.leetcode.p1;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *
 *
 * 注意：
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 */
public class T7IntegerReverse {
    @Test
    public void test(){
        System.out.println(reverse(1534236469));
    }
    public int reverse(int x) {
        int result=0;
        while (x!=0){
            int pop=x%10;
            if(result==Integer.MAX_VALUE/10&&pop>7||result>Integer.MAX_VALUE/10||result==Integer.MIN_VALUE/10&&pop<-8||result<Integer.MIN_VALUE/10){
                return 0;
            }
            result=result*10+pop;
            x=x/10;
        }
        return result;
    }
}
