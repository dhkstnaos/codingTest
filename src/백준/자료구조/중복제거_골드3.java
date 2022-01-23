package 백준.자료구조;

import java.util.*;
import java.io.*;
/*
BitSet(33554432); 선언을 통해 최대값까지 선언하고, get 메소드를 이용해 값 확인하고 set메소드를 이용해 값 추가
*/
public class 중복제거_골드3 {
    static BitSet bs=new BitSet(33554432);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size=st.countTokens();
        int cur;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++) {
            cur=Integer.parseInt(st.nextToken());
            if(!bs.get(cur)) {
                bs.set(cur);
                sb.append(cur+" ");
            }
        }
        System.out.println(sb);
    }
}