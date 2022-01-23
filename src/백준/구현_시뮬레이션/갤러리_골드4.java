package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
public class 갤러리_골드4 {
    static int[][] map;
    static int n,m,result=0;
    static boolean[][] left,right,up,down;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n=Integer.parseInt(str[0]);
        m=Integer.parseInt(str[1]);
        map=new int[n][m];
        left=new boolean[n][m];
        right=new boolean[n][m];
        up=new boolean[n][m];
        down=new boolean[n][m];
        for(int i=0;i<n;i++) {
            String tmp=br.readLine();
            for(int j=0;j<m;j++) {
                char c=tmp.charAt(j);
                if(c=='X') map[i][j]=1;
                else map[i][j]=0;
            }
        }
        for(int i=1;i<n-1;i++) {
            for(int j=1;j<m-1;j++) {
                check_column(i,j); //가로
                check_row(i,j); //세로
            }
        }
        System.out.println(result);
    }
    private static void check_column(int x,int y) {
        if(map[x][y]==0&& map[x][y+1]==0) { //가로일 경우 위 아래
            if(map[x-1][y]==1&&map[x-1][y+1]==1&&!up[x][y]) { //위
                up[x][y]=true; up[x][y+1]=true;
                result++;
            }
            if(map[x+1][y]==1&&map[x+1][y+1]==1&&!down[x][y]) {//아래
                down[x][y]=true; down[x][y+1]=true;
                result++;
            }
        }
    }
    private static void check_row(int x,int y) { //세로
        if(map[x][y]==0&& map[x+1][y]==0) {
            if(map[x][y-1]==1&&map[x+1][y-1]==1&&!left[x][y]) { //왼쪽
                left[x][y]=true; left[x+1][y]=true;
                result++;
            }
            if(map[x][y+1]==1&&map[x+1][y+1]==1&&!right[x][y]) {//오른쪽
                right[x][y]=true; right[x+1][y]=true;
                result++;
            }
        }
    }
}