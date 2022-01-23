package 백준.그리디;

import java.util.*;
class time implements Comparable<time> {
    int s;int e;
    public time(int s,int e) {
        this.s=s; this.e=e;
    }
    @Override
    public int compareTo(time t) {
        if(this.e==t.e) {
            return this.s-t.s;
        }
        else {
            return this.e-t.e;
        }
    }
}
public class 회의실배정_실버2 {
    public static int[][] arr = new int[9][9];
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        time[] arr = new time[N];
        for(int i = 0; i < N; i++) {
            int start = in.nextInt();	// 시작시간
            int end = in.nextInt();	// 종료시간
            arr[i]=new time(start,end);
        }
        Arrays.sort(arr);
        int count=0;
        int prev_time=0;
        for(int i=0;i<N;i++) {
            if(prev_time<=arr[i].s) {
                prev_time=arr[i].e;
                count++;
            }
        }
        System.out.println(count);
    }
}