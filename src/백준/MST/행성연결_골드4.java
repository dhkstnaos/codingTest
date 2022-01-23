package 백준.MST;

import java.io.*;
import java.util.*;
public class 행성연결_골드4 {
    private static int[] parent;
    private static int N;
    private static List<Edge> edgeList = new ArrayList<>();
    private static long answer = 0;
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();
                if (c != 0) { // 연결 가능한 경우
                    edgeList.add(new Edge(i, j, c));
                }
            }
        }
        Collections.sort(edgeList);
        for (Edge edge: edgeList) {
            if (find(edge.start)!=find(edge.end)) {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(answer);
    }
    private static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }
    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}