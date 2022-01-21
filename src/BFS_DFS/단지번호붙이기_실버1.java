package BFS_DFS;
import java.util.Arrays;
import java.util.Scanner;
/*
* https://www.acmicpc.net/problem/2667
* 예제 입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
* 예제 출력
3
7
8
9
* */
public class 단지번호붙이기_실버1 {
    private static int dx[] = {0,0,1,-1};
    private static int dy[] = {1,-1,0,0};
    private static int[] aparts = new int[25*25];
    private static int n;
    private static int apartNum = 0;
    private static boolean[][] visited = new boolean[25][25];
    private static int[][] map = new int[25][25];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    apartNum++;
                    dfs(i,j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(apartNum);
        for(int i=0;i<aparts.length;i++) {
            if(aparts[i]!=0) {
                System.out.println(aparts[i]);
            }
        }
    }
    static void dfs(int x,int y) {
        visited[x][y]=true;
        aparts[apartNum]++;
        for(int i=0;i<4;i++) {
            int nx=x+dx[i]; int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==1 && !visited[nx][ny]) {
                dfs(nx,ny);
            }

        }
    }
}