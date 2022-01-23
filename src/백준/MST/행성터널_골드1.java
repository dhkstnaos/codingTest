package 백준.MST;
import java.io.*;
import java.util.*;
/*
좌표를 간선으로 바꾸고 크루스칼을 돌리는 문제 간선을 최소로 넣기위해서 x,y,z 좌표로 정렬 후에 값을 구한다.
*/
class Point {
    int num;
    int x;
    int y;
    int z;
    Point(int num, int x, int y, int z) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;
    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}
public class 행성터널_골드1 {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x, y, z);
        }
        edgeList = new ArrayList<>();
        //모든 간선을 추가할 필요없이 각 축으로 정렬하고 weight를 구한다.
        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].x - points[i + 1].x);
            edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
        }
        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].y - points[i + 1].y);
            edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
        }
        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(points[i].z - points[i + 1].z);
            edgeList.add(new Edge(points[i].num, points[i + 1].num, weight));
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        Collections.sort(edgeList);
        int ans = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (find(edge.start) != find(edge.end)) {
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(ans);
    }
    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x); y = find(y);
        if (x != y) parent[y] = x;
    }
}