package 백준.자료구조;

import java.io.*;
import java.util.*;
public class 카드정렬하기_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long cnt = 0;
        Queue<Long> q=new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            q.add(Long.parseLong(br.readLine()));
        }
        while(q.size()>1) {
            long sum=q.poll()+q.poll(); //두개를 꺼내서
            cnt+=sum;
            q.add(sum);
        }
        System.out.println(cnt);
    }
}