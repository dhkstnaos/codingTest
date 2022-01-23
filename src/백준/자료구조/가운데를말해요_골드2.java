package 백준.자료구조;

import java.util.*;
/*Max Heap과 Min Heap으로 중간 값을 알아낸다.
        양 힙에 번갈아 가면서 값을 넣고 MaxHeap의 Peek()가 MinHeap의 Peek()보다 크다면 값을 교환한다.*/
public class 가운데를말해요_골드2 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            int num=sc.nextInt();
            if(minHeap.size() == maxHeap.size()) maxHeap.add(num);
            else minHeap.add(num);
            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && (maxHeap.peek()>minHeap.peek())) {
                int tmp=minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(tmp);
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}