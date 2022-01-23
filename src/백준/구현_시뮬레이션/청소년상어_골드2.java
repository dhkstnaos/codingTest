package 백준.구현_시뮬레이션;

import java.util.*;
import java.io.*;
/*
4X4 공간이 있고 물고기가 있으며 방향이 표시되어 있다.
        이동할 수 있는 칸은 빈 칸 또는 다른 물고기가 있는 칸이다.
        1. 상어가 들어간다.
        2. 번호가 작은 순으로 물고기가 이동할 수 있는 방향의 숫자와 맞바꾸기를 한다.
        3. 물고기가 이동할 수 없는 칸이라면 반시계 방향으로 45도 회전한다.*/
public class 청소년상어_골드2 {
    static class Shark {
        int x, y, dir, sum;
        Shark(int x, int y, int dir, int sum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sum = sum;
        }
    }
    static class Fish implements Comparable<Fish>{
        int x, y, num, dir;
        boolean life = true;
        Fish(int x, int y, int num, int dir, boolean life) {
            this.x = x;this.y = y;this.num = num;
            this.dir = dir; this.life = life;
        }
        @Override
        public int compareTo(Fish o) {
            return this.num-o.num;
        }
    }
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[4][4];
        List<Fish> fishes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishes.add(new Fish(i,j,num,dir,true)); //물고기 정보 추가
                arr[i][j] = num;
            }
        }
        Collections.sort(fishes);
        Fish f = fishes.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, f.dir, f.num);
        f.life = false;
        arr[0][0] = -1;
        dfs(arr, shark, fishes);
        System.out.println(max);
    }
    static void dfs(int[][] arr, Shark shark, List<Fish> fishes) {
        max=Math.max(max,shark.sum);
        for(Fish f : fishes) move(f, arr, fishes);
        for (int i = 1; i < 4; i++) {
            int nx = shark.x + dx[shark.dir] * i;
            int ny = shark.y + dy[shark.dir] * i;
            if(nx<0||ny<0||nx>=4||ny>=4) continue;
            if (arr[nx][ny] > 0) {
                int[][] next_arr = copyArr(arr);
                List<Fish> next_list = copyFishes(fishes);
                next_arr[shark.x][shark.y] = 0;
                Fish f = next_list.get(arr[nx][ny] - 1);
                Shark next_shark = new Shark(f.x, f.y, f.dir, shark.sum + f.num);
                f.life = false; //list에 false가 반영된다.
                next_arr[f.x][f.y] = -1; //상어의 위치로 물고기가 갈 수 없게 -1
                dfs(next_arr, next_shark, next_list);
            }
        }
    }
    static void move(Fish f, int[][] arr, List<Fish> fishes) {
        if (f.life == false) return;
        for (int i = 0; i < 8; i++) {
            int dir = (f.dir + i) % 8;
            int nx = f.x + dx[dir];
            int ny = f.y + dy[dir];
            if(nx<0||ny<0||nx>=4||ny>=4) continue;
            if(arr[nx][ny]==-1) continue; //상어가 있는 자리는 갈 수 없다.
            arr[f.x][f.y] = 0;
            if (arr[nx][ny] == 0) { //0이면
                f.x = nx;
                f.y = ny;
            }
            else {
                Fish temp = fishes.get(arr[nx][ny] - 1);
                temp.x = f.x;
                temp.y = f.y;
                arr[f.x][f.y] = temp.num;
                f.x = nx;
                f.y = ny;
            }
            arr[nx][ny] = f.num;
            f.dir = dir;
            return;
        }
    }
    //Deep Copy
    static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }
    //Deep Copy
    static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        fishes.forEach(e -> temp.add(new Fish(e.x, e.y, e.num, e.dir, e.life)));
        return temp;
    }
}