package DSA;


public class Dp{
    public int fib_memo(int n){
        int memo[] = new int[n+1];
        for(int i = 0; i<memo.length;++i){
            memo[i] = -1;
        }
        return fibohelp(n, memo);
    }

    private int fibohelp(int n, int memo[]){
        if(n<=1){
            return n;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] = fibohelp(n-2, memo)+fibohelp(n-1, memo);
        return memo[n];
    }

    public int fib_tab(int n){
        if(n<=1){
            return n;
        }
        int tb[] = new int[n+1];
        tb[0] = 0;
        tb[1] = 1;
        for(int i = 2; i<tb.length; ++i){
            tb[i] = tb[i-2]+tb[i-1];
        }
        return tb[n];
    }
}