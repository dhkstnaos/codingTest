package 백준.그리디;
import java.io.*;
import java.util.*;
/*
입력 값:
4
1 5
3 8
7 9
6 11
Queue
1. 5
2. 5 8
3. 8 9  // 5는 9보다 작거나 같기 때문에 poll();
4. 11 // 8,9도 작기 때문에 poll();
5.  최대 사이즈가 2가 된다.
---
1. 시작 시간에 대해 오름차순으로 정렬하고 같을 경우 종료 시간에 대해 오름차순으로 정렬하는 클래스를 만든다.
2. arraylist에 값을 추가하고 정렬한다.
3. 큐에 정렬된 첫번째 원소의 종료 시간을 넣는다.
4. 다음 회의 시작 시간이 큐에 있는 시간보다 크다면 회의가 끝나고 들어갈 수 있다는 뜻이므로 큐에 있는
 숫자를 없애거나 해당 종료시간보다 작거나 같은 큐의 값은 poll() 시켜 size()를 줄인다.
5. 그 후 종료 시간을 add 시킨다.
6. q.size()가 회의실 사용 개수를 나타낸다. size가 가장 클 때가 최소 사용 개수가 된다.
* */
class point implements Comparable<point>{
    int s,e;
    public point(int s,int e) {
        this.s=s; this.e=e;
    }
    @Override
    public int compareTo(point p) {
        if(this.s==p.s) {
            return this.e-p.e;
        }
        return this.s-p.s;
    }
}
public class 최소회의실개수_골드5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> q=new PriorityQueue<>();
        ArrayList<point> list=new ArrayList<>();
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            list.add(new point(s,e));
        }
        Collections.sort(list);
        q.add(list.get(0).e);
        int cnt=1;
        for(int i=1;i<n;i++) {
            while(!q.isEmpty() && q.peek()<=list.get(i).s) {
                q.poll();
            }
            q.add(list.get(i).e);
            cnt=Math.max(cnt,q.size());
        }
        System.out.println(cnt);
    }
}