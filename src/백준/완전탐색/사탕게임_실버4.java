package 백준.완전탐색;

import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/3085
 * */
public class 사탕게임_실버4 {
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[][] arr=new char[n][n];
        int ans=0;
        for(int i=0;i<n;i++) {
            String str=sc.next();
            for(int j=0;j<n;j++) {
                arr[i][j]=str.charAt(j);
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<4;k++) {
                    int px=i+dx[k]; int py=j+dy[k];
                    if(px<0||py<0||px>=n||py>=n) continue;
                    if(arr[i][j]!=arr[px][py]) {
                        char t=arr[i][j];
                        arr[i][j]=arr[px][py];
                        arr[px][py]=t;
                        int temp=check(arr);
                        if(ans<temp) ans=temp;
                        t=arr[i][j];
                        arr[i][j]=arr[px][py];
                        arr[px][py]=t;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static int check(char[][] a) {
        int n = a.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt)
                    ans = cnt;
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt)
                    ans = cnt;
            }
        }
        return ans;
    }
}