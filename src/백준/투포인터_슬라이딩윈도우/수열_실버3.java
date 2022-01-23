package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/2559
 * */
public class 수열_실버3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum=0;
        for(int i=0;i<k;i++) {
            sum+=arr[i];
        }
        int max=sum;
        for(int i=k;i<n;i++) {
            sum+=arr[i];
            sum-=arr[i-k];
            max=Math.max(max,sum);
        }
        System.out.println(max);
    }
}