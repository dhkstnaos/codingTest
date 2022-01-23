package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/15686
 * */
class Point {
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 치킨배달_골드5 {
    static int n, m, result;
    static boolean[] visited;
    static int[][] map;
    static ArrayList<Point> person=new ArrayList<>();
    static ArrayList<Point> chicken=new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    person.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        result = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(result);
    }
    public static void dfs(int start, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        temp = Math.min(temp, cal(person.get(i),chicken.get(j)));
                    }
                }
                sum += temp;
            }
            result = Math.min(result, sum);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
    private static int cal(Point d1, Point d2) {
        return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
    }
}