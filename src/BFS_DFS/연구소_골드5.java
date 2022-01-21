package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* https://www.acmicpc.net/problem/14502
* 예제 입력
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
* 예제 출력
* : 27
* */
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x; this.y = y;
    }
}
public class 연구소_골드5 {
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};

    public static int n, m;
    public static int[][] map;
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for(int i = 0; i < n; i++)
            for(int j = 0 ; j < m; j++)
                map[i][j] = sc.nextInt();


        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(1); // 빈 곳을 벽으로 채운다.
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int cnt) {
        if(cnt==3) { // 벽이 3개가 됐을때 bfs 함수 호출
            bfs();
            return;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(map[i][j]==0) {
                    map[i][j]=1; //visited[]=true;
                    dfs(cnt+1);
                    map[i][j]=0; //visited[]=false;
                }
            }
        }
    }
    public static void bfs() { //바이러스를 퍼지게 한다.
        int[][] virusMap=new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                virusMap[i][j] = map[i][j];
        Queue<Pair> q=new LinkedList<Pair>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(virusMap[i][j]==2) {
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()) {
            Pair p=q.poll();
            for(int i=0;i<4;i++) {
                int nx=p.x+dx[i];
                int ny=p.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(virusMap[nx][ny]==0) {
                    virusMap[nx][ny]=2;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        cal(virusMap);
    }
    public static void cal(int[][] virusMap) { // 안전 영역 계산
        int cnt=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(virusMap[i][j]==0) cnt++;
            }
        }
        answer=Math.max(answer,cnt);
    }
}