package 백준.구현_시뮬레이션;

/*
이동 횟수가 10회로 늘었다.
        시간복잡도는 보드 크기가 최대 20이어서 20*20*4^10=400*1024*1024 이어서 최악의 경우 4억번이기 때문에 4초가 걸린다.
        그러나 문제에서 자바의 시간 제한이 5초로 늘어났기 때문에 EASY 문제의 코드를 그대로 제출해도 된다.
        가지치기를 통해서 시간 복잡도를 1/3 줄였다.
        주어진 맵에 대해 depth 10을 도달할 때마다의 depth마다의 최대값은 depth가 줄어들때마다 나누기 2가 될
        것이다. 배열에 저장해놓고 추후에 해당 depth에서 이미 저장된 최대값보다 작거나 같다면 최대값이 갱신될
        수가 없기 때문에 더이상 진행하지 않아도 된다.
*/
import java.io.*;
import java.util.*;
public class 이공사팔어려움_플레4 {
    static int n, result=0,tmp_max;
    static int[][] map;
    static int[] depth_max=new int[11];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        combination(map,0);
        System.out.println(result);
    }
    private static int cal_max() {
        int max=0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                max = Math.max(max, map[i][j]);
        return max;
    }
    public static void combination(int[][] board,int count) {
        tmp_max=cal_max();
        if(tmp_max<=depth_max[count]) return;
        if(count == 10) {
            int save=result=Math.max(tmp_max,result);
            while(count>0) {
                depth_max[count--]=save;
                save/=2;
            }
            return;
        }
        int[][] back = copy(map);
        for(int i = 0; i < 4; i++) {
            combination(move(i),count+1);
            for(int j = 0; j < n; j++) //원상복구
                map[j] = back[j].clone();
        }
    }
    private static int[][] copy(int[][] a) {
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++)
            tmp[i] = a[i].clone();
        return tmp;
    }
    public static int[][] move(int dir) {
        switch(dir) {
            case 0: //위
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index - 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1: //아래
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[index + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][index + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
        return map;
    }
}