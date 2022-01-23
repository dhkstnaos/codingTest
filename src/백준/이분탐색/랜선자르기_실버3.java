package 백준.이분탐색;

import java.io.*;
import java.util.*;
public class 랜선자르기_실버3 {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt(); long n=sc.nextLong();
        long max=0;
        long[] arr = new long[k];
        for(int i=0;i<k;i++) {
            arr[i]=sc.nextLong();
            max=Math.max(max,arr[i]);
        }
        long left=1; long right=max;
        long mid=0;
        while(left<=right) {
            mid=(left+right)/2;
            long sum=0;
            for(int i=0;i<k;i++) {
                sum+=arr[i]/mid;
            }
            if(n<=sum) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}