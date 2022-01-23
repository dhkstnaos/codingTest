package 백준.구현_시뮬레이션;
import java.io.*;
import java.util.*;
class point {
    int r,c,amount;
    point(int r, int c, int amount) {
        this.r = r;
        this.c = c;
        this.amount = amount;
    }
}
public class 미세먼지안녕_골드4 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int R, C, T;
    static int[][] map;
    static Queue<point> q = new LinkedList<>();
    static int[] cleaner = new int[2];
    static int answer = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map=new int[R][C];
        int cleaner_idx=0;
        for(int i=0;i<R;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1) {
                    cleaner[cleaner_idx++]=i;
                }
            }
        }
        for(int i=0;i<T;i++) {
            wind();
            rotating();
        }
        for ( int i=0; i<R; i++) {
            for ( int j=0; j<C; j++) {
                if ( map[i][j] != -1 && map[i][j] !=0 ) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
    private static void rotating() {
        int top = cleaner[0];
        int down = cleaner[1];
        for (int i = top-1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[top][i] = map[top][i-1];
            if ( i== 2) map[top][i-1] =0;
        }
        map[top][0] = -1;
        for (int i = down+1; i < R-1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R-1][i] = map[R-1][i + 1];
        }
        for (int i = R-1; i > down; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[down][i] = map[down][i - 1] ;
            if ( i== 2) map[down][i-1] =0;
        }
        map[down][0] = -1;
    }
    private static void wind() {
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(map[i][j]>0) {
                    q.add(new point(i,j,map[i][j]));
                }
            }
        }
        int cnt,amount;
        while(!q.isEmpty()) {
            point now=q.poll();
            cnt=0;
            amount=now.amount/5;
            for(int i=0;i<4;i++) {
                int nr=now.r+dx[i];
                int nc=now.c+dy[i];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(map[nr][nc]!=-1) {
                    map[nr][nc]+=amount;
                    cnt++;
                }
            }
            map[now.r][now.c]= map[now.r][now.c]-amount*cnt;
        }
    }
}