package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/14465
 * */
public class 소가길을건너간이유5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int k=Integer.parseInt(str[1]);
        int b=Integer.parseInt(str[2]);
        int[] sum = new int[n + 1];
        boolean[] fix = new boolean[n + 1];
        for (int i = 0; i < b; i++) {
            fix[Integer.parseInt(br.readLine())] = true;
        }
        int cnt=0;
        for(int i=1;i<=k;i++) {
            if(fix[i]) cnt++;
        }
        sum[k]=cnt; int ans=cnt;
        for(int i=k+1;i<=n;i++) {
            int prev=sum[i-1];
            if(fix[i]) prev++;
            if(fix[i-k]) prev--;
            sum[i]=prev;
            ans=Math.min(ans,prev);
        }
        System.out.println(ans);
    }
}