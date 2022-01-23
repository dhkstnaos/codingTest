package 백준.구현_시뮬레이션;
import java.util.*;
public class 달팽이_실버5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int[][] arr = new int[w][w];
        int findn = scan.nextInt();
        int[] x = {1,0,-1,0};
        int[] y = {0,1,0,-1};
        int now = 0; // x y배열 방향조절하는 숫자 0: 다운 1:오른쪽 2:업 3:왼쪽
        int nx = 0; //현재 위치 x
        int ny = 0; //현재 위치 y
        int num = w*w; // 전체돌았는지 확인, 값 넣는 변수
        int fx = 0; //찾으려는 숫자 위치값 x
        int fy = 0; //찾으려는 숫자 위치값 y
        while(num > 0) {
            arr[nx][ny] = num;
            if(num == findn) {
                fx = nx;
                fy = ny;
                fx++; fy++;
            }
            if(nx+x[now] >= arr.length || ny+y[now] >= arr.length
                    || nx+x[now] < 0 || ny+y[now] < 0 || arr[nx+x[now]][ny+y[now]] != 0) {
                if(now == 3 ) { now = 0; }
                else { now += 1;}
            }
            nx += x[now];
            ny += y[now];
            num--;

        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<w;i++) {
            for(int j=0;j<w;j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(fx).append(" ").append(fy);
        System.out.println(sb);
    }
}