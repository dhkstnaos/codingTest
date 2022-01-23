package 백준.완전탐색;

import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/9095
 * */
public class 백준123더하기_실버3 {
    static int n,sum;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for (int i = 0; i < n; i++) {
            sum=0;
            int tg = sc.nextInt();
            dfs(tg,0);
            System.out.println(sum);
        }
    }
    static void dfs(int target,int n) {
        if(target<n) return;
        else if(target==n) {
            sum++;
            return;
        }
        else {
            dfs(target,n+1);
            dfs(target,n+2);
            dfs(target,n+3);
        }
    }
}