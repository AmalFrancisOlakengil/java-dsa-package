package DSA;


public class Dp{
    public int fib_memo(int n){
        int memo[] = new int[n+1];
        for(int i = 0; i<memo.length;++i){
            memo[i] = -1;
        }
        return fibohelp(n, memo);
    }

    public int fibohelp(int n, int memo[]){
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
        return 1;
    }
}