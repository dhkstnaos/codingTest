package 백준.유니온파인드;

import java.util.Scanner;

/*
* https://www.acmicpc.net/problem/20040
* 예제 입력
6 5
0 1
1 2
1 3
0 3
4 5
* 예제 출력
* : 4
* */
public class 사이클게임_골드4 {
    static int[] parent;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); int m=sc.nextInt();
        parent=new int[n];
        for(int i=0;i<n;i++) {
            parent[i]=i;
        }
        int ans=0;
        for(int i=0;i<m;i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(find(a)!=find(b)) {
                union(a,b);
            }
            else {
                ans=i+1;
                break;
            }
        }
        System.out.println(ans);
    }
    static int find(int x) {
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int x,int y) {
        x=find(x); y=find(y);
        if(x!=y) {
            if(x<y) {
                parent[y]=x;
            }
            else {
                parent[x]=y;
            }
        }
    }
}