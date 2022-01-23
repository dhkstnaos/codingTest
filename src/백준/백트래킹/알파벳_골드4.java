package 백준.백트래킹;
import java.io.*;
import java.util.*;
public class 알파벳_골드4 {
    static int r, c;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static char board[][];
    static int result = 0;
    static HashSet<Character> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        for(int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }
        hs.add(board[0][0]);
        dfs(0, 0, 1);
        System.out.print(result);
    }
    public static void dfs(int x,int y,int count) {
        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0||ny<0||nx>=r||ny>=c) continue;
            if(hs.contains(board[nx][ny])) {
                result=Math.max(result,count);
            }
            else {
                hs.add(board[nx][ny]); // 방문 표시
                dfs(nx,ny,count+1);
                hs.remove(board[nx][ny]); //방문 해제
            }
        }
    }
}