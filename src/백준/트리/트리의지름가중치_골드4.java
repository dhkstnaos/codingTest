package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * https://www.acmicpc.net/problem/1967
 */
public class 트리의지름가중치_골드4 {
    static class Node {
        int child,dist;
        Node(int child,int dist) {
            this.child=child;
            this.dist=dist;
        }
    }
    static int n ;
    static ArrayList<Node>[] list;
    static int[] parents;
    static boolean[] check;
    static int max=0,number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        list=new ArrayList[n+1];
        for(int i=0;i<=n;i++) {
            list[i]=new ArrayList<Node>();
        }
        for(int i=0;i<n-1;i++) {
            st=new StringTokenizer(br.readLine());
            int parent_node=Integer.parseInt(st.nextToken());
            int child_node=Integer.parseInt(st.nextToken());
            int distance=Integer.parseInt(st.nextToken());
            list[parent_node].add(new Node(child_node,distance));
            list[child_node].add(new Node(parent_node,distance));
        }
        check=new boolean[n+1];
        dfs(1,0);
        check=new boolean[n+1];
        dfs(number,0);
        System.out.println(max);
    }
    static void dfs(int idx,int length) {
        if(length>max) {
            max=length;
            number=idx;
        }
        check[idx]=true;
        for(Node n : list[idx]) {
            if(!check[n.child]) {
                check[n.child]=true;
                dfs(n.child,length+n.dist);
            }
        }
    }
}