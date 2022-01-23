package 백준.그리디;
/*
    두 개의 큐를 두어 양수 큐와 음수 큐를 둔다.
        또한 더 멀리 있는 곳 부터 가야 최단 거리로 다녀올
        수 있기 때문에 내림차순으로 정렬 해둔다. 최단 거리로 가려면 가장
        먼 곳을 마지막에 가야 되돌아 오지 않기 때문에 최대 거리를 저장해두고 계산에서 미리 빼둔다.*/
import java.util.*;
import java.io.*;
public class 도서관_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> positiveQ = new PriorityQueue<>((o1,o2)->o2-o1);
        Queue<Integer> negativeQ = new PriorityQueue<>((o1,o2)->o2-o1);
        int max=0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            max=Math.max(Math.abs(temp),max);
            if (temp > 0) {
                positiveQ.add(temp);
            } else {
                negativeQ.add(Math.abs(temp));
            }
        }
        int ans = max*-1;
        while (!positiveQ.isEmpty()) {
            int temp = positiveQ.poll();
            for (int i = 0; i < M - 1; i++) {
                positiveQ.poll();
                if (positiveQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }
        while (!negativeQ.isEmpty()) {
            int temp = negativeQ.poll();
            for (int i = 0; i < M - 1; i++) {
                negativeQ.poll();
                if (negativeQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }
        System.out.println(ans);
    }
}