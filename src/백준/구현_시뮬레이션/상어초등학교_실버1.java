package 백준.구현_시뮬레이션;

import java.util.*;
import java.io.*;
public class 상어초등학교_실버1 {
    static int N, map[][], empty[][], num[], like[][];
    static ArrayList<Node> list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        empty = new int[N][N];
        num = new int[N * N];
        like = new int[N * N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = 4;
                if (i == 0 || i == N-1) n--;
                if (j == 0 || j == N-1) n--;
                empty[i][j] = n;
            }
        }
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N * N; i++) {
            list = new ArrayList<>();
            add(i);
            Collections.sort(list);
            Node node = list.get(0);

            map[node.x][node.y] = num[i];
            empty[node.x][node.y] = -1;
            for (int j = 0; j < 4; j++) {
                int xx = node.x + dx[j];
                int yy = node.y + dy[j];
                if (xx < 0 || xx >= N || yy < 0 || yy >= N || empty[xx][yy] < 1) continue;
                empty[xx][yy]--;
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N * N; k++) {
                    if (map[i][j] == num[k]) {
                        int cnt = 0;
                        for (int kk = 0; kk < 4; kk++) {
                            int xx = i + dx[kk];
                            int yy = j + dy[kk];
                            if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
                            for (int r = 0; r < 4; r++) {
                                if (map[xx][yy] == like[k][r]) {
                                    cnt++;
                                    break;
                                }
                            }
                        }
                        if (cnt == 1) result += 1;
                        else if (cnt == 2) result += 10;
                        else if (cnt == 3) result += 100;
                        else if (cnt == 4) result += 1000;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static void add(int idx) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) continue;
                Node node = new Node();
                node.x = i;
                node.y = j;
                node.empty = empty[i][j];
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int xx = i + dx[k];
                    int yy = j + dy[k];
                    if (xx < 0 || xx >= N || yy < 0 || yy >= N || map[xx][yy] == 0) continue;
                    for (int kk = 0; kk < 4; kk++) {
                        if (map[xx][yy] == like[idx][kk]) {
                            cnt++;
                            break;
                        }
                    }
                }
                node.like = cnt;
                list.add(node);
            }
        }
    }
    static class Node implements Comparable<Node> {
        int x, y, like, empty;
        @Override
        public int compareTo(Node o) {
            if (this.like != o.like) return o.like - this.like;
            if (this.empty != o.empty) return o.empty - this.empty;
            if (this.x != o.x) return this.x - o.x;
            return this.y - o.y;
        }
    }
}