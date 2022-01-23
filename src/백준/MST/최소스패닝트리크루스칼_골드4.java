package 백준.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
    최소 스패닝 트리는 spanning Tree 중에서 사용된 간선들의 **가중치 합이 최소인 것이다.**

        크루스칼 알고리즘은 가장 가중치가 적은 것부터 간선을 연결한다. 유니온파인드 이용

        프림은 시작 정점부터 선택할 수 있는 가장 작은 정점을 선택한다. 우선순위큐 사용

        MST 하면 간적크, 간만프를 생각해야 한다.

        간선이 적으면 크루스칼, 간선이 많으면 프림

        간선이 10만개라 프림 알고리즘 적용해야 한다.
*/
public class 최소스패닝트리크루스칼_골드4 {
    static int V,E;
    static ArrayList<Node>[] adj;
    static class Node implements Comparable<Node> {
        int to ; int weight;
        public Node(int to, int weight) {
            this.to=to; this.weight=weight;
        }
        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());    // 정점 개수
        E = Integer.parseInt(st.nextToken());    // 간선 개수
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++) {
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }
        System.out.println(prim());
    }
    private static long prim() {
        boolean[] visited=new boolean[V+1];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(1,0));
        long res=0; int cnt=0;
        while(!pq.isEmpty()) {
            Node node=pq.poll();
            if(visited[node.to]) continue;
            res+=node.weight;
            visited[node.to]=true;
            if(++cnt==V) return res;
            for(int i=0;i<adj[node.to].size();i++) {
                Node next=adj[node.to].get(i);
                if(visited[next.to]) continue;
                pq.add(next);
            }
        }
        return res;
    }
}