package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
/*
2048은 전체블록을 상하좌우로 합치는 것이고 같은 값을 갖는 블록이 충돌하면 합쳐진다.
        조합을 이용해서 방문 체크를 했고 방문 전 배열을 저장하고 방문 후 해당 배열을 다시 옮기는 작업을 했다.
        시간복잡도는 보드 크기가 최대 20이어서 20*20*4^5=400*1024= 404800 1억번이 넘지 않는다 (1억번이 1초)
*/
public class 이공사팔쉬움_골드2 {
    static int n, result=0;
    static int[][] map;
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

    public static void combination(int[][] board,int count) {
        if(count == 5) {
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    result = Math.max(result, map[i][j]);
            return;
        }
        int[][] back = new int[n][n];
        for(int i = 0; i < n; i++)
            back[i] = map[i].clone();
        for(int i = 0; i < 4; i++) {
            combination(move(i),count+1);
            for(int j = 0; j < n; j++) //원상복구
                map[j] = back[j].clone();
        }
    }
    public static int[][] move(int dir) {
        switch(dir) {
            case 0: //위
                for(int i = 0; i < n; i++) {
                    int idx = 0;
                    int value = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[j][i] != 0) {
                            if(value == map[j][i]) {
                                map[idx - 1][i] = value * 2;
                                value = 0;
                                map[j][i] = 0;
                            }
                            else {
                                value = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = value;
                                idx++;
                            }
                        }
                    }
                }
                break;
            case 1: //아래
                for(int i = 0; i < n; i++) {
                    int idx = n - 1;
                    int value = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[j][i] != 0) {
                            if(value == map[j][i]) {
                                map[idx + 1][i] = value * 2;
                                value = 0;
                                map[j][i] = 0;
                            }
                            else {
                                value = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = value;
                                idx--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < n; i++) {
                    int idx = 0;
                    int value = 0;
                    for(int j = 0; j < n; j++) {
                        if(map[i][j] != 0) {
                            if(value == map[i][j]) {
                                map[i][idx - 1] = value * 2;
                                value = 0;
                                map[i][j] = 0;
                            }
                            else {
                                value = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = value;
                                idx++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i < n; i++) {
                    int idx = n - 1;
                    int value = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(map[i][j] != 0) {
                            if(value == map[i][j]) {
                                map[i][idx + 1] = value * 2;
                                value = 0;
                                map[i][j] = 0;
                            }
                            else {
                                value = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = value;
                                idx--;
                            }
                        }
                    }
                }
                break;
        }
        return map;
    }
}