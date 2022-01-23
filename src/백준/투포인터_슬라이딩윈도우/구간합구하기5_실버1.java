package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
/*
 * https://www.acmicpc.net/problem/11660
 * */
public class 구간합구하기5_실버1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[][] = new int[N+1][N+1];
        int dp[][] = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // 누적 값에는 왼쪽 위쪽의 값을 더해주고 중복 값인 대각선 값은 빼준다.
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
        for(int i = 0; i< M; i++) {
            int ax = sc.nextInt(); int ay = sc.nextInt();
            int bx = sc.nextInt(); int by = sc.nextInt();
            int tmp= dp[bx][by]-dp[bx][ay-1]-dp[ax-1][by]+dp[ax-1][ay-1];
            System.out.println(tmp);
        }
    }
}