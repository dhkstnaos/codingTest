package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/10025
 * */
public class 게으른백곰_실버4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[1000001];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int g=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            arr[x]=g;
        }
        int sum=0,max=0,d=1+2*k;
        for(int i=0;i<=1000000;i++) {
            if(i>=d) {
                sum-=arr[i-d];
            }
            sum+=arr[i];
            max=Math.max(max,sum);
        }
        System.out.println(max);
    }
}