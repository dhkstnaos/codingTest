package 백준.자료구조;

import java.util.*;
import java.io.*;
public class 중앙값구하기_골드2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=null;
        while(t-->0) {
            int n=Integer.parseInt(br.readLine());
            int cnt=0;
            sb.append((n+1)/2+"\n");
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for(int i=0;i<n;i++) {
                if(i%10==0) {
                    st=new StringTokenizer(br.readLine());
                }
                int tmp=Integer.parseInt(st.nextToken());
                if(i%2==0) maxHeap.add(tmp);
                else minHeap.add(tmp);
                if(!maxHeap.isEmpty() && !minHeap.isEmpty() && (maxHeap.peek()>minHeap.peek())) {
                    int ch=minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(ch);
                }
                if(i%2==0) {
                    if(cnt==9 || i==n-1) {
                        sb.append(maxHeap.peek() + "\n");
                        cnt=0;
                    }
                    else {
                        sb.append(maxHeap.peek()+" ");
                    }
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}