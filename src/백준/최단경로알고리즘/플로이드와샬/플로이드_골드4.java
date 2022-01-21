package 백준.최단경로알고리즘.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/11404
* */
public class 플로이드_골드4 {
    public static int cityCount;
    public static int[][] distance;
    public static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());
        distance = new int[cityCount+1][cityCount+1];
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }
        while(busCount-->0) {
            st=new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            distance[s][e]=Math.min(distance[s][e],time);
        }
        floydWarshall();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=cityCount;i++) {
            for(int j=1;j<=cityCount;j++) {
                if(distance[i][j]>=INF) sb.append("0 ");
                else sb.append(distance[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void floydWarshall() {
        for(int k=1;k<=cityCount;k++) {
            for(int i=1;i<=cityCount;i++) {
                for(int j=1;j<=cityCount;j++) {
                    distance[i][j]=Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
    }
}