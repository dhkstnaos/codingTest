package 백준.그리디;

import java.util.*;
public class 주유소_실버3 {
    public static int[][] arr = new int[9][9];
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        long[] dist = new long[N - 1];	// 거리
        long[] cost = new long[N];
        for(int i = 0; i < N - 1; i++) {
            dist[i] = in.nextLong();
        }
        for(int i = 0; i < N; i++) {
            cost[i] = in.nextLong();
        }
        long sum=0; long min=cost[0];
        for(int i=0;i<N-1;i++) {
            if(cost[i]<min) {
                min=cost[i];
            }
            sum+=dist[i]*min;
        }
        System.out.println(sum);
    }
}