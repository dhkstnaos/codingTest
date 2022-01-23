package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/15565
 * */
public class 귀여운라이언 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
            if(Integer.parseInt(st.nextToken())==1) {
                list.add(i);
            }
        }
        if(list.size()<k) {
            System.out.println(-1);
            System.exit(0);
        }
        int min=1000000;
        int s=0,e=k-1;
        while(true) {
            int tmp=list.get(e)-list.get(s)+1;
            min=Math.min(tmp,min);
            if(e==list.size()-1) break;
            s++; e++;
        }
        System.out.println(min);
    }
}