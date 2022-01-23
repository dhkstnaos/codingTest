package 백준.그리디;

import java.util.*;
public class 다리놓기_실버5 {
    static int[][] dp;
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        dp=new int[31][31];
        for(int i=0;i<n;i++) {
            int b = in.nextInt(); int a = in.nextInt();
            System.out.println(f(a,b));
        }
    }
    static int f(int N,int K) {
        if(N==K || K==0) return 1;
        if(dp[N][K]==0) {
            dp[N][K]=(f(N-1,K-1)+f(N-1,K));
        }
        return dp[N][K];
    }
}