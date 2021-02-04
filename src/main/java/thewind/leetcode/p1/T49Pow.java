package thewind.leetcode.p1;

public class T49Pow {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }else if(n==0){
            return 1;
        }
        if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE){
            return 0;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            return myPow(x*x,n>>1);
        }else {
            return x*myPow(x*x,n>>1);
        }
    }
}
