package 백준.완전탐색;


import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/6603
 * */
public class 로또 {
    static int n;
    static int[] arr;
    static boolean visited[];
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            if(n==0) break;
            arr=new int[n];
            visited=new boolean[n];
            for(int i=0;i<n;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int start,int depth) {
        if(depth==6) {
            for(int i=0;i<n;i++) {
                if(visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<n;i++) {
            visited[i]=true;
            dfs(i+1,depth+1);
            visited[i]=false;
        }
    }
}