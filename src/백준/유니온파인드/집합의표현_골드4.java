package 백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/1717
* 예제 입력
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
* 예제 출력
NO
NO
YES
* */
public class 집합의표현_골드4 {
    static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;
        for(int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int calculation=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(calculation==0) {
                union(a,b);
            }
            else if(calculation==1) {
                sb.append((isSameParent(a,b) ? "YES" : "NO") + "\n");
            } else continue;
        }
        System.out.println(sb);
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
    static boolean isSameParent(int x, int y) {
        return find(x)==find(y);
    }
}