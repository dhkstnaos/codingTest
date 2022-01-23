package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
/*겉부터 돌리면서 들어간다. 회전의 총 횟수는 행과 열의 작은 값/2가 된다.*/
public class 배열돌리기1_실버2 {
    static int n,m,rotate;
    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        rotate=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        rotating();
        print();
    }
    private static void rotating() {
        int count=Math.min(n,m)/2;
        for(int i=0;i<rotate;i++) {
            for(int j=0;j<count;j++) {
                int x,y;
                x=y=j;
                int value=arr[j][j]; //시작 값 저장
                int idx=0;
                while(idx<4) { //4방향 완료 시
                    int nx=x+dx[idx];
                    int ny=y+dy[idx];
                    if(nx>=j&&ny>=j&&nx<n-j&&ny<m-j) {
                        arr[x][y]=arr[nx][ny];
                        x=nx;
                        y=ny;
                    }
                    else idx++;
                }
                arr[j+1][j]=value;
            }
        }
    }
    private static void print() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}