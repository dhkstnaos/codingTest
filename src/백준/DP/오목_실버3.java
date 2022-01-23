package 백준.DP;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/2615
 * */
public class 오목_실버3 {
    static int[][] map = new int[21][21];
    static int[][][] cnt = new int[21][21][ 4];
    static int[] dx = { 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1 };
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (cnt[i][j][d] == 0 && dp(i, j, d, map[i][j]) == 5) {
                            System.out.println(map[i][j]);
                            System.out.println(i+" "+j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
    private static int dp(int x, int y, int dir, int color) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (map[nx][ny] == color) {
            return cnt[nx][ny][dir] = dp(nx, ny, dir, color) + 1; // cnt가 저장
        }
        return 1;
    }
}