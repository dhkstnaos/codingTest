package 백준.백트래킹;

import java.util.*;
public class 연산자끼워넣기_실버1 {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = in.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator[i] = in.nextInt();
        }
        dfs(number[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);


        public static void dfs(int num, int idx) {
            if (idx == N) {
                MAX = Math.max(MAX, num);
                MIN = Math.min(MIN, num);
                return;
            }
            for (int i = 0; i < 4; i++) {
                if (operator[i] > 0) {
                    // 해당 연산자를 1 감소시킨다.
                    operator[i]--;
                    switch (i) {
                        case 0:	dfs(num + number[idx], idx + 1);	break;
                        case 1:	dfs(num - number[idx], idx + 1);	break;
                        case 2:	dfs(num * number[idx], idx + 1);	break;
                        case 3:	dfs(num / number[idx], idx + 1);	break;
                    }
                    operator[i]++;
                }
            }
        }

    }