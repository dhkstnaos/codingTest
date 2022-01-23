package 백준.MST;

import java.io.*;
import java.util.*;
public class 도시분할계획_골드4 {
    static int V, E, parent[];
    static Edge[] edgeList;
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());    // 정점 개수
        E = Integer.parseInt(st.nextToken());    // 간선 개수
        edgeList = new Edge[E];
        parent = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(a, b, c);
        }
        System.out.println(kruskal());
    }
    //마을을 두개로 나눴기 때문에 n개의 정점에 n-1개의 간선에서
    // n개의 정점에서 n-2개의 간선이 된다. 최소한의 비용으로 분할하기 위해선
    // 가장 큰 비용의 간선을 제거하면 된다.
    private static int kruskal() {
        int res = 0, cnt = 0;
        Arrays.sort(edgeList);
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        int max=0;
        for (Edge edge : edgeList) {
            if(find(edge.from)!=find(edge.to)) {
                res += edge.weight;
                union(edge.from,edge.to);
                max=edge.weight;
                if(++cnt == V - 1) break;
            }
        }
        return res-max;
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
    private static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}