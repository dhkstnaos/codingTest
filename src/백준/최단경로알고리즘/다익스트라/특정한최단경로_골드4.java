package 백준.최단경로알고리즘.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/1504
* */
class Point implements Comparable<Point>{
    int end;
    int weight;
    public Point(int end, int weight){this.end = end; this.weight = weight;}
    @Override
    public int compareTo(Point o) {
        return this.weight - o.weight;
    }
}
public class 특정한최단경로_골드4 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 200_000_000;
    static List<Point> list[];
    static int dist[];
    static boolean check[];
    static int n, v;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        // 그래프 정보 저장할 list를 초기화한다.
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        dist = new int[n + 1];
        check = new boolean[n + 1];
        // 간선 정보 초기화
        for(int i = 0 ; i < v; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, weight));
            list[end].add(new Point(start, weight));
        }
        st = new StringTokenizer(br.readLine());
        int require1 = Integer.parseInt(st.nextToken());
        int require2 = Integer.parseInt(st.nextToken());
        System.out.println(solve(require1, require2));
    }
    private static int solve(int required1, int required2){
        int result1 = 0;
        int result2 = 0;
        //중간의 경로를 거쳐 가야 할때 ex) 2,3을 거칠때 2번 먼저 가는 경우 3번 먼저 가는 경우가 있다.
        result1 += dijkstra(1, required1) + dijkstra(required1, required2) + dijkstra(required2, n);
        result2 += dijkstra(1, required2) + dijkstra(required2, required1) + dijkstra(required1, n);
        if(result1 >= INF && result2 >= INF) return -1;
        else return Math.min(result1, result2);
    }

    private static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;
            if(check[curNode]) continue;
            check[curNode] = true;
            for(Point next: list[curNode]){
                if(dist[next.end] > curWeight + next.weight){
                    dist[next.end] = curWeight + next.weight;
                    queue.add(new Point(next.end, dist[next.end])); //다음 경로 추가
                }
            }
        }
        return dist[end];
    }
}