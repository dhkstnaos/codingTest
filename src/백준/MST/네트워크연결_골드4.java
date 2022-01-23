package 백준.MST;

import java.util.*;
import java.io.*;
public class 네트워크연결_골드4 {
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
        st = new StringTokenizer(br.readLine());
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
            Node now=pq.poll();
            if(visited[now.to]) continue;
            res+=now.weight;
            visited[now.to]=true;
            if(++cnt==V) return res;
            for(Node next: adj[now.to]) {
                if(!visited[next.to]) pq.add(next);
            }
        }
        return res;
    }
}