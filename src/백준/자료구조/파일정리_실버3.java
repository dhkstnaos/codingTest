package 백준.자료구조;

import java.util.*;
/*Comparator<String> comparator = (s1, s2)->s2.compareTo(s1); //내림차순 구현
TreeMap은 해쉬맵에서 키 순으로 정렬을 한 자료구조입니다.
        위의 comparator를 사용해 내림차순도 구현할 수 있습니다.*/
public class 파일정리_실버3 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //Comparator<String> comparator = (s1, s2)->s2.compareTo(s1);
        TreeMap<String,Integer> hm=new TreeMap<String,Integer>();
        for(int i=0;i<n;i++) {
            String[] files=sc.next().split("\\.");
            String file=files[1];
            hm.put(file,hm.getOrDefault(file,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,Integer> entry : hm.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}