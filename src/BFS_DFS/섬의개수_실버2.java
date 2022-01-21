package BFS_DFS;

import java.util.*;
import java.io.*;
/*
* https://www.acmicpc.net/problem/4963
* 예제 입력
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
* 예제 출력
0
1
1
3
1
9
* */
public class 섬의개수_실버2 {
    static int[][] island;
    static int[] dx={0,1,1,1,0,-1,-1,-1};
    static int[] dy={1,1,0,-1,-1,-1,0,1};
    static int w,h;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st=new StringTokenizer(br.readLine());
            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());
            if(w==0&&h==0) break;
            island=new int[w][h];
            int sum=0;
            for(int i=0;i<h;i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    island[j][i]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(island[j][i]==1) {
                        sum++;
                        dfs(j,i);
                    }
                }
            }
            System.out.println(sum);
        }
    }
    public static void dfs(int x,int y) {
        island[x][y]=0;
        for(int i=0;i<8;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=w||ny>=h) continue;
            if(island[nx][ny]==0) continue;
            dfs(nx,ny);
        }
    }
}