```java
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int end=0; //디스크가 끝나고 시작하는 지점
        int idx=0; // 배열의 idx
        int count=0; //처리 디스크
        //요청 시간으로 정렬
        Arrays.sort(jobs,(o1,o2)-> o1[0]-o2[0]);
        //큐는 소요시간이 짧은 순으로 정렬
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        while(count<jobs.length) {
            //idx가 범위 안에 있고 요청시간부터 end 지점까지의 요청들을 큐에 넣기
            while(idx<jobs.length && jobs[idx][0]<=end) {
                pq.add(jobs[idx]);
                idx++;
            }
            if(pq.isEmpty()) { //큐가 비어 있다면 end 후에 요청이 들어온 것
                end=jobs[idx][0];
            }
            else { // 비어 있지 않다면 end 전에 들어온 것
                int[] tmp=pq.poll();
                answer+=end+tmp[1]-tmp[0];
                end+=tmp[1];
                count++;
            }
        }
        return answer/jobs.length;
    }
}
```
