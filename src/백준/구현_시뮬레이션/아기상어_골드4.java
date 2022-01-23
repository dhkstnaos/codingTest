package 백준.구현_시뮬레이션;
/*
### 풀이 방법
        1. 시작 지점을 두고 매 시작 지점을 물고기를 먹은 곳으로 갱신한다.
        2. 매 bfs 지점마다 큐와 리스트 방문 배열을 초기화한다.
        3. 큐가 빌 때까지 순회하면서 이동거리가 갱신된 것보다 짧으면서 아기 상어의 크기가 먹이보다 크면서 0이 아닐때 리스트에 추가하고 최소 이동거리를 move에 넣어 갱신한다.
        4. 상어보다 크기가 같거나 0인 경우는 이동거리만 늘리고 큐에 추가한다
        5. 과정이 끝이나면 방문 표시를 한다.
        6. list 추가된 먹이들을 X 좌표 오름차순으로 하되 x 좌표가 같을 경우 y 좌표 오름차순으로 정렬을 수행한다.
        7. 만약 list가 비어있다면 실행을 종료하고 값을 출력한다.
        8. 정렬을 수행한 후 0번째 먹이가 아기 상어가 먹을 먹이가 된다.
        9. 거리를 갱신하고 아기상어 위치를 0으로 만든다*/
import java.io.*;
import java.util.*;
class Point implements Comparable<Point> {
    int x; int y; int d;
    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
    @Override
    public int compareTo(Point o) {
        if(this.x==o.x) {
            return this.y-o.y;
        }
        return this.x-o.x;
    }
}
public class 아기상어_골드4 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int N,sx,sy;
    public static int result = 0;
    public static int shark = 2;
    public static int eat = 0;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        N=Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                }
            }
        }
        while (bfs());
    }
    private static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sx, sy, 0));
        ArrayList<Point> list = new ArrayList<>(); //물고기 리스트
        visited = new boolean[N][N];
        visited[sx][sy] = true;
        int minMove = 1000;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visited[nx][ny]) continue;
                if (minMove > p.d && shark >= map[nx][ny]) {
                    if (map[nx][ny] < shark && map[nx][ny] != 0) {
                        list.add(new Point(nx, ny, p.d + 1));
                        minMove = p.d + 1;
                        break;
                    }
                    else q.add(new Point(nx, ny, p.d + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        if(list.isEmpty()) {
            System.out.println(result);
            System.exit(0);
        }
        Collections.sort(list);
        int nx = list.get(0).x;
        int ny = list.get(0).y;
        result += list.get(0).d;
        map[sx][sy] = 0;
        map[nx][ny] = 0;
        eat++;
        if (eat == shark) {
            shark++;
            eat = 0;
        }
        sx = nx;
        sy = ny;
        return true;
    }
}