package 백준.트리;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/5639
 */
public class 이진검색트리_실버1 {
    static int[] tree = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 0;
        while (sc.hasNext())
            tree[idx++] = sc.nextInt();
        postOrder(0, idx - 1);

    }

    static void postOrder(int n, int end) {
        if (n > end)
            return;

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n])
            mid++;

        postOrder(n + 1, mid - 1);
        postOrder(mid, end);
        System.out.println(tree[n]);
    }
}