package 백준.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * https://www.acmicpc.net/problem/3273
 * */
public class 두수의합_실버3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(stz.nextToken());
        int[] arr=new int[n];
        int count=0;
        stz = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++) {
            arr[i]=Integer.parseInt(stz.nextToken());
        }
        Arrays.sort(arr);
        stz = new StringTokenizer(br.readLine());
        int x=Integer.parseInt(stz.nextToken());
        int s=0; int e=n-1;
        while(s<e) {
            int sum=arr[s]+arr[e];
            if(sum==x) {
                count++;
            }
            if(sum<=x) {
                s++;
            }
            else {
                e--;
            }
        }
        System.out.println(count);
    }
}