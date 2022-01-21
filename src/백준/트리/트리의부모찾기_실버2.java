package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/11725
*/
public class 트리의부모찾기_실버2 {
    static int n ;
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[n+1];
        parents = new int[n+1];
        check = new boolean[n+1];
        for(int i=1;i<=n;i++) list[i]=new ArrayList<Integer>();
        for(int j=1;j<n;j++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b); list[b].add(a);
        }
        // for(int k=1;k<=n;k++) {
        //    if(!check[k]) {
        //        dfs(k);
        //    }
        //}
        bfs(1);
        for (int i = 2; i <=n ; i++) {
            System.out.println(parents[i]);
        }
    }
    public static void dfs(int v) {
        if(check[v]) return;
        check[v]=true;
        for(int value: list[v]) {
            if(!check[value]) {
                parents[value]=v;
                dfs(value);
            }
        }
    }
    public static void bfs(int start) {
        LinkedList<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        check[start]=true;
        while(!queue.isEmpty()) {
            int parent=queue.poll();
            for(int child: list[parent]) {
                if(!check[child]) {
                    check[child] = true;
                    parents[child]=parent;
                    queue.add(child);
                }
            }
        }
    }
}