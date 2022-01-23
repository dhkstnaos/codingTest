package 백준.완전탐색;


import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/18429
 * */
public class 근손실_실버3{
    public static int n,k,arr[];
    public static boolean visited[];
    public static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n]; visited=new boolean[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        dfs(0,0);
        System.out.println(result);
    }
    public static void dfs(int depth,int sum) {
        if(sum<0) return;
        if(depth==n) {
            result++;
            return;
        }
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i]=true;
                dfs(depth+1,sum+arr[i]-k);
                visited[i]=false;
            }
        }
    }

}