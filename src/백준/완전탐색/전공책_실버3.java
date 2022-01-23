package 백준.완전탐색;

import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/16508
 * */
public class 전공책_실버3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t=br.readLine();
        int t_leng=t.length();
        int n = Integer.parseInt(br.readLine());
        String[] title=new String[n];
        int[] cost=new int[n];
        for(int i=0;i<n;i++) {
            String[] temp=br.readLine().split(" ");
            cost[i]=Integer.parseInt(temp[0]);
            title[i]=temp[1];
        }
        int total=1<<n;
        int answer=-1;
        for(int i=1;i<total;i++) {
            int[] cnt=new int[26];
            int costSum=0;
            for(int j=0;j<n;j++) {
                if((i&(1<<j))!=0) {
                    String tmp=title[j];
                    for(int k=0;k<tmp.length();k++) {
                        cnt[tmp.charAt(k)-'A']++;
                    }
                    costSum+=cost[j];
                }
            }
            if(chk(cnt,t)) {
                if(answer==-1) answer=costSum;
                else answer=Math.min(answer,costSum);
            }
        }
        System.out.println(answer);

    }
    public static boolean chk(int[] cnt,String t) {
        for(int i=0;i<t.length();i++) {
            if(cnt[t.charAt(i)-'A']==0) return false;
            cnt[t.charAt(i)-'A']--;
        }
        return true;
    }
}