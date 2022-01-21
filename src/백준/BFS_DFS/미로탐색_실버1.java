package 백준.BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
* https://www.acmicpc.net/problem/2178
* 예제 입력
4 6
101111
101010
101011
111011
* 예제 출력
* : 15
* */
public class 미로탐색_실버1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] maze = new int[n][m];

        for (int i=0; i<n; i++) {
            String s = br.readLine();

            for (int j=0; j<m; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs(n, m, maze);
        System.out.println(result);
    }

    static int bfs(int n, int m, int[][] maze) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<Dot> q = new LinkedList<>();
        maze[0][0] = 0;
        q.add(new Dot(0, 0, 1));

        while (!q.isEmpty()) {
            Dot dot = q.poll();

            if (dot.x == n-1 && dot.y == m-1) {
                return dot.count;
            }

            for (int i=0; i<4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (maze[nx][ny] == 1) {
                        maze[nx][ny] = 0;
                        q.add(new Dot(nx, ny, dot.count + 1));
                    }
                }
            }
        }

        return 0;
    }

    static class Dot {
        int x, y, count;

        Dot(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}