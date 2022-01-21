package 백준.최단경로알고리즘.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/1753
* 다익스트라는 V개의 정점,
* E개의 간선을 가진 그래프에서 출발 정점 S부터 다른 모든 정점까지의
* 최단 경로를 구하는 알고리즘이다.
 * */
public class 최단경로_골드5 {
    static ArrayList<Edge>[] adj;
    static boolean[] check;
    static int[] dist;
    static class Edge implements Comparable<Edge> {
        int destination;
        int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) { //가중치를 기준으로 오름차순 정렬
            return this.weight-o.weight;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        adj = new ArrayList[V+1]; //인접리스트 생성
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v,w));
        }
        check = new boolean[V+1];
        dist = new int[V+1];
        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i]!=Integer.MAX_VALUE)
                sb.append(dist[i] + "\n");
            else
                sb.append("INF\n");
        }
        System.out.println(sb);
    }
    public static void dijkstra(int start){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        priorityQueue.add(new Edge(start,0));
        dist[start] = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int destination = edge.destination;
            if(check[destination]) continue;
            else check[edge.destination] = true;
            //확인한 경로는 true 표시
            for (Edge next : adj[destination]) {
                //현재 next의 최단 경로보다 destination을 거쳐가는 것이 더 가깝다면 갱신
                if (dist[next.destination] >= dist[destination] + next.weight) {
                    dist[next.destination] = dist[destination] + next.weight;
                    priorityQueue.add(new Edge(next.destination,dist[next.destination]));
                }
            }
        }
    }
}