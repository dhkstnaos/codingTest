package 백준.이분탐색;

import java.io.*;
import java.util.*;
public class 예산_실버3 {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long max=0;
        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextLong();
            max=Math.max(max,arr[i]);
        }
        long m=sc.nextLong();
        long left=0; long right=max;
        while(left<=right) {
            long mid=(left+right)>>>1; //비트 연산자 /2 와 같다.
            long sum=0;
            for(int i=0;i<n;i++) {
                sum+=Math.min(mid,arr[i]);
            }
            if(sum<=m) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}