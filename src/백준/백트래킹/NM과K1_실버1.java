package 백준.백트래킹;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.*;
public class NM과K1_실버1 {
    static int N,M,K;
    static int max=Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        combination(0,0);
        System.out.println(max);
    }
    public static void combination(int depth,int sum) {
        if (depth == K) {
            max=Math.max(sum,max);
            return;
        }
        for (int i = 0; i < N; i++) {
            for(int j=0;j<M;j++) {
                if(checked(i,j)==true&&visited[i][j]==false) {
                    visited[i][j]=true;
                    combination(depth + 1,sum+arr[i][j]);
                    visited[i][j]=false;
                }
            }
        }
    }
    public static boolean checked(int i,int j) {
        for(int k=0;k<4;k++) {
            int x=i+dx[k]; int y=j+dy[k];
            if(x>=0&&x<N&&y>=0&&y<M&&visited[x][y]==true) {
                return false;
            }
        }
        return true;
    }
}