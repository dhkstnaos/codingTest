package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/11659
 * */
public class 구간합구하기_실버3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        st=new StringTokenizer(br.readLine()); //빈 칸을 제거
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] arr=new int[N+1];
        st=new StringTokenizer(br.readLine());
        int sum=0;
        int[] sum_arr=new int[N+1];
        sum_arr[0]=0;
        for(int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
            sum_arr[i]=sum;
        }
        for(int i=0;i<M;i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            System.out.println(sum_arr[end]-sum_arr[start-1]);
        }
    }
}