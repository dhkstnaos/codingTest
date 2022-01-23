package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/1476
 * */
public class 날짜계산_실버5 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int eNum=15; int sNum=28; int mNum=19;
        int e=sc.nextInt();
        int s=sc.nextInt();
        int m=sc.nextInt();
        int ans=1;
        for(int i=1;i<Integer.MAX_VALUE;i++) {
            if((i-e)%eNum==0 && (i-s)%sNum==0 && (i-m)%mNum==0 ) {
                ans=i;
                break;
            }
        }
        System.out.println(ans);
    }
}