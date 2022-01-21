package 백준.최단경로알고리즘.벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* https://www.acmicpc.net/problem/11657
* 벨만 포드 알고리즘은 음의 가중치를 포함하는 최단 경로를 구할 수 있다.
* 다익스트라에 비하여 많은 시간이 소요된다.
* 시간 복잡도 - O(VE)
* */
public class 타임머신_골드4 {
    private static int n, m;
    private static Info[] infos;
    private static Long[] dist;
    private static final Long INF = Long.MAX_VALUE;
    private static class Info {
        int s;
        int e;
        int cost;
        public Info(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        infos = new Info[m+1];
        dist = new Long[n + 1];
        Arrays.fill(dist, INF);
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            infos[i] = new Info(a, b, c);
        }
        if (!bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println(dist[i].equals(INF) ? -1 : dist[i]);
            }
        }
    }
    private static boolean bellmanFord() {
        dist[1] = 0L;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= m; j++) {
                Info info = infos[j];
                if (dist[info.s] != INF && dist[info.e] > dist[info.s] + info.cost) {
                    dist[info.e] = dist[info.s] + info.cost;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            Info info = infos[i];
            if (dist[info.s] != INF && dist[info.e] > dist[info.s] + info.cost) {
                return false;
            }
        }
        return true;
    }
}