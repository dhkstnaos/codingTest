package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/1806
 * */
public class 부분합_골드4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int first=0; int second=0; int ans = 100001, sum = 0;
        while(true) {
            if(sum>=s) {
                sum-=arr[first++];
                ans=Math.min(ans,second-first+1); //최소값 갱신
            }
            else if(second==n) break;
            else {
                sum+=arr[second++];
            }
        }
        if(ans==100001) {
            System.out.println(0);
        } else System.out.println(ans);
    }
}