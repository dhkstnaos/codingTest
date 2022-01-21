package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * https://www.acmicpc.net/problem/14675
1. 트리는 사이클이 없고, 모든 정점이 연결되어 있다. (문제에 나와있다.)
2. N개의 정점이 있을때 N-1개의 간선을 가진다.
**현재 트리인 상태에서 어떠한 간선을 하나 지우면 항상 두개의 트리로 나눠질 수 밖에 없다.**
1. 루트, 리프 정점을 삭제한 경우 - 간선이 하나만 있다.
2. 루트, 리프 정점이 아닌 정점을 삭제한 경우 간선이 두 개 이상이다.
 */
public class 단절점과단절선_골드5 {
    static ArrayList<Integer>[] list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list=new ArrayList[n+1];
        for(int i=0;i<=n;i++) {
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n-1;i++) {
            st=new StringTokenizer(br.readLine());
            int p=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[p].add(c);
            list[c].add(p);
        }
        int q=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++) {
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            if(t==2) sb.append("yes\n");
            else {
                int cnt=0;
                for(int num: list[k]) {
                    cnt++;
                }
                if(cnt>=2) sb.append("yes\n");
                else sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}