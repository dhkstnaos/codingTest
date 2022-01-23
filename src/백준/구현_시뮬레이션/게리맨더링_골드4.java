package 백준.구현_시뮬레이션;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/17779
 * ## 문제
재현시는 크기가 N×N인 격자로 나타낼 수 있다. 격자의 각 칸은 구역을 의미하고,
* r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다. 구역을 `다섯 개의 선거구`로
* 나눠야 하고, `각 구역은 다섯 선거구 중 하나`에 포함되어야 한다. 선거구는
* 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두
* 연결되어 있어야 한다. 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때,
* 두 구역은 연결되어 있다고 한다. 중간에 통하는 인접한 구역은 0개 이상이어야 하고,
*  모두 같은 선거구에 포함된 구역이어야 한다.
* 1. 일단 입력을 받고 경계구역으로 지정할 곳을 찾는다.
* 2. 모든 구역을 돌아보면서 (d1,d2≥1,)
 * */
public class 게리맨더링_골드4 {
    static int n,total,min=Integer.MAX_VALUE, map[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map=new int[n][n];
        //값 배정
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                total+=map[i][j];
            }
        }
        assign();
        System.out.println(min);
    }
    private static void assign() {
        for(int d1=1;d1<n;d1++) {
            for(int d2=1;d2<n;d2++) {
                for(int x=0;x<n;x++) {
                    for(int y=0;y<n;y++) {
                        if(y-d1>=0 && y+d2<n && x+d1+d2<n) {
                            solve(x,y,d1,d2);
                        }
                    }
                }
            }
        }
    }
    private static void solve(int x,int y,int d1,int d2) {
        boolean[][] bound=new boolean[n][n];
        //경계 구역에 true 설정
        for(int i=0;i<=d1;i++) {
            bound[x+i][y-i]=true;
            bound[x+d2+i][y+d2-i]=true;
        }
        for(int i=0;i<=d2;i++) {
            bound[x+i][y+i]=true;
            bound[x+d1+i][y-d1+i]=true;
        }
        int[] count = new int[5];
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (bound[i][j]) break;
                count[0] += map[i][j];
            }
        }
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (bound[i][j]) break;
                count[1] += map[i][j];
            }
        }
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (bound[i][j]) break;
                count[2] += map[i][j];
            }
        }
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (bound[i][j]) break;
                count[3] += map[i][j];
            }
        }
        count[4] = total;
        for (int i = 0; i < 4; i++) {
            count[4] -= count[i];
        }
        Arrays.sort(count);
        min = Math.min(min, count[4] - count[0]);
    }
}