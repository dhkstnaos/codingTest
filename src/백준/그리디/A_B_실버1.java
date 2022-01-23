package 백준.그리디;

import java.util.*;
//숫자의 범위가 10^9로 long 타입을 써주어야 한다.
public class A_B_실버1 {
    static long a,b,result=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b= sc.nextInt();
        dfs(a,1);
        if(result==Integer.MAX_VALUE) result=-1;
        System.out.println(result);
    }
    public static void dfs(long num,long cnt) {
        if(num>b) return;
        if(num==b) {
            result=Math.min(cnt,result);
            return;
        }
        dfs(num*2,cnt+1);
        dfs(num*10+1,cnt+1);
    }
}