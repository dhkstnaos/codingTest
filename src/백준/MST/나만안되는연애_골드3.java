package 백준.MST;
import java.io.*;
import java.util.*;
/*
같은 성별끼리와의 경로는 매칭이 되지 않기 때문에 조건을 추가한다.
*/
public class 나만안되는연애_골드3 {
    static int V, E, parents[];
    static Edge[] edgeList;
    static char[] sex;
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
        sex = new char[V + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=V;i++) {
            sex[i]=st.nextToken().charAt(0);
        }
        edgeList = new Edge[E];
        parents = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(a, b, c);
        }
        System.out.println(kruskal());
    }
    private static int kruskal() {
        int res = 0, cnt = 0;
        Arrays.sort(edgeList);
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
        for (Edge edge : edgeList) {
            if(find(edge.from)!=find(edge.to) ) {
                if(sex[edge.from]!=sex[edge.to]) {
                    res += edge.weight;
                    union(edge.from,edge.to);
                    if(++cnt == V - 1) break;
                }
            }
        }
        return cnt==V-1 ? res : -1;
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parents[b]=a;
        }
    }
    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}