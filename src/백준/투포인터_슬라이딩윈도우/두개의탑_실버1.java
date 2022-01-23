package 백준.투포인터_슬라이딩윈도우;

import java.io.*;
/*
 * https://www.acmicpc.net/problem/2118
 * */
public class 두개의탑_실버1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N+1];
        int sum=0;
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        int s=0,e=0,ans=0;
        int dist=arr[0];
        while(s<=e&&e<N) {
            int min=Integer.min(dist,sum-dist);
            ans=Math.max(ans,min);
            //거리가 정방향이 작다면
            //거리가 작은 값 중 최대값을 구하기 때문에
            //정방향 거리가 감소하는 idx를 찾을 필요는 없다.
            if(dist==min) {
                e++;
                dist+=arr[e];
            }
            else {
                dist-=arr[s];
                s++;
            }
        }
    }
}