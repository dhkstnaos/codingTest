package 백준.최단경로알고리즘.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/10217
* */
public class KCM_Travel_골드1 {
    static class AirPlane implements Comparable<AirPlane> {
        int e,c,t;
        AirPlane(int e,int c,int t) {
            this.e=e; this.c=c; this.t=t;
        }
        @Override
        public int compareTo(AirPlane airPlane) {
            if(this.t==airPlane.t) return c-airPlane.c;
            else return this.t-airPlane.t;
        }
    }
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 100 * 1_000;
    static int N,M,K;
    static ArrayList<AirPlane> list[];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int test=0;test<T;test++) {

            st = new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            dp=new int[N+1][M+1];
            list=new ArrayList[N+1];
            for(int i=0;i<=N;i++) {
                Arrays.fill(dp[i],INF);
                list[i]=new ArrayList<AirPlane>();
            }
            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int start=Integer.parseInt(st.nextToken());
                int end=Integer.parseInt(st.nextToken());
                int cost=Integer.parseInt(st.nextToken());
                int time=Integer.parseInt(st.nextToken());
                list[start].add(new AirPlane(end,cost,time));
            }
            int result = dijkstra();
            sb.append(result == INF ? "Poor KCM\n" : result + "\n");
        }
        System.out.println(sb);
        br.close();
    }
    public static int dijkstra() {
        for(int i=1;i<dp.length;i++) { Arrays.fill(dp[i],INF); }
        PriorityQueue<AirPlane> pq=new PriorityQueue<AirPlane>();
        pq.add(new AirPlane(1,0,0));
        dp[1][0]=0;
        while(!pq.isEmpty()) {
            AirPlane airPlane=pq.poll();
            int node=airPlane.e;
            int cost=airPlane.c;
            int time=airPlane.t;
            if(node==N) break;
            if(dp[node][cost]<time) continue;
            dp[node][cost]=time;
            for(int i=0;i<list[node].size();i++) {
                AirPlane toAirplane = list[node].get(i);
                int toNode = toAirplane.e;
                int toCost = cost + toAirplane.c;
                int toTime = time + toAirplane.t;
                if(toCost>M) continue;
                if(dp[toNode][toCost]>toTime) {
                    for(int j=toCost;j<=M;j++) {
                        if(dp[toNode][j]>toTime) dp[toNode][j]=toTime;
                    }
                    pq.add(new AirPlane(toNode,toCost,toTime));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=M;i++) {
            min=Math.min(min,dp[N][i]);
        }
        return min;
    }
}