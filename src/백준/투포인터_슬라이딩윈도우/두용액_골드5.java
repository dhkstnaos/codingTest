package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/2470
 * */
public class 두용액_골드5 {
    static int pick1 = -1;
    static int pick2 = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        solution(n, arr);
        System.out.println(pick1 + " " + pick2);
    }
    static void solution(int n, int[] arr) {
        int left = 0;
        int right = n-1;
        int max = 2_000_000_000;
        while(left < right) {
            int sum = arr[left] + arr[right];
            // 두 용액 갱신
            if(Math.abs(sum) < max) {
                pick1 = arr[left];
                pick2 = arr[right];
                max = Math.abs(sum);
            }
            if(sum > 0)
                right--;
            else
                left++;
        }
    }
}