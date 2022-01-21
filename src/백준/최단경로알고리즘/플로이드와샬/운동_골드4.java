package 백준.최단경로알고리즘.플로이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/1956
* 플로이드 와샬을 사용해 모든 경로의 최단 거리를 구하고 사이클을 구한다.
* 요구 사항이 2~400이기 떄문에 v^3이 최대 시간 복잡도이다.
* 시간 복잡도 최대 64_000_000번 연산
* */
public class 운동_골드4 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 400 * 10_000;
    static int v, e, result = INF;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new int[v + 1][v + 1];
        for(int i = 0; i <= v; i++) Arrays.fill(arr[i], INF);
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[start][end]=dist;
        }
        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
                for(int k = 1; k <= v; k++){
                    if(arr[j][k] > arr[j][i] + arr[i][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int max=INF;
        for(int i=1;i<=v;i++) {
            max=Math.min(max,arr[i][i]);
        }
        if(max==INF) {
            sb.append("-1\n");
        }
        else sb.append(max+"\n");
        System.out.println(sb);
    }
}