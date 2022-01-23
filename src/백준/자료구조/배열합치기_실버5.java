package 백준.자료구조;

import java.util.*;
import java.io.*;
/*우선선위큐로 값을 정렬하고 while문을 돌리면서 peek()로 값 비교 후 poll()*/
public class 배열합치기_실버5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        st=new StringTokenizer(br.readLine()); //빈 칸을 제거
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        Queue<Integer> first=new PriorityQueue<>();
        Queue<Integer> second=new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            first.add(Integer.parseInt(st.nextToken()));
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            second.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb=new StringBuilder();
        while(true) {
            if(first.size()>0&&second.size()>0) {
                if(first.peek()<second.peek()) {
                    sb.append(first.poll()).append(" ");
                }
                else {
                    sb.append(second.poll()).append(" ");
                }
            }
            else {
                if(first.isEmpty()) {
                    while(!second.isEmpty()) {
                        sb.append(second.poll()).append(" ");
                    }
                    break;
                }
                else{
                    while(!first.isEmpty()) {
                        sb.append(first.poll()).append(" ");
                    }
                    break;
                }
            }

        }
        System.out.println(sb);
    }
}