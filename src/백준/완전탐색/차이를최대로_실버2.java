package 백준.완전탐색;

import java.util.*;
/*
 * https://www.acmicpc.net/problem/10819
 * */
public class 차이를최대로_실버2 {
    static int n ;
    static int[] arr;
    static int result=0;
    static int[]  makeArr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();
        arr =new int[n];
        visited =new boolean[n];
        makeArr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] =sc.nextInt();
        }
        solve(0);
        System.out.println(result);
    }
    private static void solve(int count){
        if(count == n){
            int sum =0;
            for (int i = 0; i <n-1 ; i++) {
                sum += Math.abs(makeArr[i] - makeArr[i+1]);
            }
            result = Math.max(result,sum);
            return;
        }
        for (int i = 0; i <n ; i++) {
            if(!visited[i]){
                visited[i] =true;
                makeArr[count] = arr[i];
                solve(count+1);
                visited[i] =false;
            }
        }
    }
}