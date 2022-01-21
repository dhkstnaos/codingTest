package 백준.최단경로알고리즘.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/9370
* */
public class 미확인도착지_골드2 {
    static class Node implements Comparable<Node>{
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 10_000_000;
    static int vertex, edge, t;
    static int start, g, h;
    static int arr[][];
    static int dist[];
    static boolean check[];
    static List<Integer> answerList;
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCnt; i++){
            // n,m,t 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            // 그래프 배열 선언
            arr = new int[vertex + 1][vertex + 1];
            dist = new int[vertex + 1];
            for(int j = 0 ; j < arr.length; j++)
                Arrays.fill(arr[j], INF);
            Arrays.fill(dist, INF);
            check = new boolean[vertex + 1];
            // s, g, h 초기화
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 그래프 정보 저장
            for(int j = 0 ; j < edge; j++){
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                // 2배의 가중치 짝수로 저장한다.
                arr[vertex1][vertex2] = arr[vertex2][vertex1] = distance * 2;
            }
            // 2배된 값에 -1을 하여 홀수를 만든다.
            arr[h][g] = arr[g][h] = arr[h][g] - 1;
            // 후보정답 list선언
            answerList = new ArrayList<>();
            // 후보가 되는 값 추가
            for(int j = 0; j < t; j++)  answerList.add(Integer.parseInt(br.readLine()));
            dijkstra();
            Collections.sort(answerList);
            for(int num : answerList)
                if(dist[num] % 2 == 1) System.out.print(num+" ");
            System.out.println();
        }
    }

    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;
            if(check[cur]) continue;
            check[cur] = true;
            for(int i = 1; i <= vertex; i++){
                if(dist[i] > dist[cur] + arr[cur][i]){
                    dist[i] = dist[cur] + arr[cur][i];
                    queue.add(new Node(i, dist[i]));
                }
            }
        }
    }
}