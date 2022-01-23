package 백준.이분탐색;

import java.io.*;
import java.util.*;
public class 공유기설치_실버1 {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); long m=sc.nextLong();
        long max=0;
        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
        long left=1; long right=arr[n-1]-arr[0];
        long d=0; long ans=0;
        while(left<=right) {
            long mid=(left+right)/2;
            long sum=1;
            long prev=arr[0];
            for(int i=0;i<n;i++) {
                d=arr[i]-prev;
                if(d>=mid) {
                    sum++;
                    prev=arr[i];
                }
            }
            if(sum>=m) {
                ans=mid;
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
}