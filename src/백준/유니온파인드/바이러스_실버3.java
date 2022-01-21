package 백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/2606
* 예제 입력
7
6
1 2
2 3
1 5
5 2
5 6
4 7
* 예제 출력
* : 4
* */
public class 바이러스_실버3 {
    static int[] parent;
    public static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) parent[y] = x;
    }
    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(tk.nextToken());
        int cnt = 0;
        parent = new int[v + 1];
        for(int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < e; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            union(x, y);
        }

        for(int i = 2; i <= v; i++) if(isSameParent(1,i)) cnt++;
        System.out.println(cnt);
    }
}