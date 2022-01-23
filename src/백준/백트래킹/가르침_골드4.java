package 백준.백트래킹;

import java.util.*;
import java.io.*;
public class 가르침_골드4 {
    static int N, K, ans=0;
    static boolean[][] word_check;
    static boolean[] visited= new boolean[26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        word_check = new boolean[N][26];
        for (int i = 0; i < N; i++) {
            String tmp = sc.next();
            for (int j = 0; j < tmp.length(); j++) {
                word_check[i][tmp.charAt(j) - 'a'] = true;
            }
        }
        commbination(0, 0);
        System.out.println(ans);
    }
    private static void commbination(int depth, int idx) {
        if (depth == K) {
            check();
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                commbination(depth + 1,i);
                visited[i] = false;
            }
        }
    }
    private static void check() {
        int sum = 0;
        boolean flag;
        for (int k = 0; k < N; k++) {
            flag = true;
            for (int i = 0; i < 26; i++) {
                if (word_check[k][i] && !visited[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) sum++;
        }
        ans = Math.max(sum, ans);
    }
}