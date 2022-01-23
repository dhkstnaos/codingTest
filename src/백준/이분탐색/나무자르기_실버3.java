package 백준.이분탐색;

import java.io.*;
import java.util.*;
public class 나무자르기_실버3 {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long m=sc.nextLong(); //최소로 가져가야 하는 나무
        long max=0;
        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextLong();
            max=Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
        long left=1; long right=max;
        long mid=0;
        while(left<=right) {
            mid=(left+right)/2;
            long sum=0;
            for(int i=0;i<n;i++) { //O(nlogn)
                if(arr[i]>mid) {
                    sum+=arr[i]-mid;
                }
            }
            if(m<=sum) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}