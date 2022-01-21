package 백준.유니온파인드;

import java.util.Scanner;
/*
* https://www.acmicpc.net/problem/1976
* 예제 입력
3
3
0 1 0
1 0 1
0 1 0
1 2 3
* 예제 출력
YES
* */
public class 여행가자_골드4 {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //도시의 수
        int M = sc.nextInt(); //여행계획 수
        parent = new int[N+1]; // [해당노드] = 최상위부모값
        for (int i=0; i<N; i++){
            parent[i] = i; //초기화 작업
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int flag = sc.nextInt();
                if (flag == 1) {
                    union(i, j);
                }
            }
        }
        int prev = sc.nextInt();
        for (int i = 0; i < M-1; i++) {
            if (!isSameParent(prev,sc.nextInt())){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static boolean isSameParent(int x, int y) {
        return find(x)== find(y);
    }
}