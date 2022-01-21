package 백준.트리;


import java.util.Scanner;
/*
 * https://www.acmicpc.net/problem/2263
 * 트리 and 분할정복 문제
             1
     2             3
4         5          6
        7
프리오더 - **1** 2 4 5 7 3 6 Root-Left-Right
인오더 - 4 2 7 5 **1** 3 6 Left-Root-Right
포스트오더 - 4 7 5 2 6 3 **1** Left-Right-Root
position 배열에는
//position[inOrder[i]] = i;
포스트 오더의 끝에는 항상 루트이기 때문에 루트를 알 수 있다.
인오더에서는 루트를 기준으로 왼쪽은 왼쪽 오른쪽은 오른쪽 자식이다.
 */
public class 트리의순회_골드2 {
    static int [] inOrder = new int[100000];
    static int [] postOrder = new int[100000];
    static int [] position = new int[100001];

    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ;
        int root = postOrder[pe];
        System.out.print(root+" ");
        int inRoot = position[root]; //인오더의 루트 인덱스
        int left = inRoot-is; //포스트오더의 왼쪽 자식의 수
        solve(is, inRoot-1, ps, ps+left-1);
        solve(inRoot+1, ie, ps+left, pe-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i=0; i<n; i++)
            inOrder[i] = scan.nextInt();
        for(int i=0; i<n; i++)
            postOrder[i] = scan.nextInt();
        for(int i=0; i<n; i++)
            position[inOrder[i]] = i;

        solve(0, n-1, 0, n-1);
    }

}