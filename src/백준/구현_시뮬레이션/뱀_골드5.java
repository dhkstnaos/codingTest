package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
class point {
    int x,y;
    point(int x,int y) {
        this.x=x; this.y=y;
    }
}
public class 뱀_골드5 {
    static int n;
    static int[][] map;
    static Map<Integer,Character> snake;
    static int[] dx = {0,1,0,-1}; //우하좌상
    static int[] dy = {1,0,-1,0};
    static Queue<point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n][n];
        snake = new HashMap<>();
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a-1][b-1] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            snake.put(time, c);
        }
        System.out.println(moving());
    }
    static int moving() {
        q = new LinkedList<>();
        q.add(new point(0,0));
        int time=0;
        int x =0,y=0; int d=0;
        while(true) {
            time++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(checked(nx,ny)) break;
            if(map[nx][ny] ==1) {
                q.add(new point(nx,ny));
                map[nx][ny] = 0;
            }
            else {
                q.add(new point(nx,ny));
                q.poll();
            }
            if(snake.containsKey(time)) {
                char data = snake.get(time);
                if(data=='D') {
                    d=(d+1)%4;
                }
                else {
                    d = (d==0) ? 3: d-1;
                }
            }
            x = nx; y = ny;
        }
        return time;
    }
    static boolean checked(int x,int y) {
        if(x<0 || y<0 || x>=n|| y>= n) return true;
        for(point p: q) {
            if(p.x==x&&p.y==y) return true;
        }
        return false;
    }
}