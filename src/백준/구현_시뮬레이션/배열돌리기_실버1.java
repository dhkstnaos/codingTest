package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
public class 배열돌리기_실버1 {
    static int n,d;
    static int[][] arr;
    static int x,y; //배열위치
    static int s,e; //시작점, 끝점
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            if(d<0) d=360+d;
            arr=new int[n][n];
            for(int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<d/45;i++) {
                int jump=n/2;
                e=n-1;
                for(int j=0;j<n/2;j++) {
                    s=j;
                    rotating(jump);
                    jump--;
                    e--; s++;
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    sb.append(arr[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void rotating(int jump) {
        x=y=s;
        int tmp = arr[x][y];
        for(int i=x;i<=e-jump;i+=jump) {
            arr[i][y] = arr[i+jump][y];
        }
        x = e;
        for(int j=y;j<=e-jump;j+=jump) {
            arr[x][j] = arr[x][j+jump];
        }
        y = e;
        for(int i=x;i>=s+jump;i-=jump) {
            arr[i][y] = arr[i-jump][y];
        }
        x = s;
        for(int j=y;j>s+jump;j-=jump) {
            arr[x][j] = arr[x][j-jump];
        }
        y = s+jump;
        arr[x][y]=tmp;
    }
}