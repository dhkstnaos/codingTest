package 백준.투포인터_슬라이딩윈도우;


import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/1940
 * */
public class 주몽_실버4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = arr.length-1;
        int  ans = 0;
        while(s<e) {
            int sum=arr[s]+arr[e];
            if(sum==m) {
                ans++;
            }
            if(sum<=m) {
                s++;
            }
            else {
                e--;
            }
        }
        System.out.println(ans);
    }
}