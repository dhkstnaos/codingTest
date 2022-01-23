package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/2018
 * */
public class 수들의합5_실버5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int l_idx = 0, r_idx = 0; int sum = 0, ans = 0;
        while (l_idx <= n) {
            while (++r_idx <= n) {
                sum += r_idx;
                if (sum >= n) {
                    if (sum == n) ans++;
                    break;
                }
            }
            while (++l_idx <= n) {
                sum -= l_idx;
                if (sum <= n) {
                    if (sum == n) ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}