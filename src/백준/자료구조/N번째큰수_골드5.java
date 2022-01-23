package 백준.자료구조;

import java.util.*;
import java.io.*;
public class N번째큰수_골드5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
            String[] str=br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                q.add(Integer.parseInt(str[j]));
            }
        }
        int count=0;
        for(int i=1;i<=n;i++) {
            count=q.poll();
        }
        System.out.println(count);
    }
}