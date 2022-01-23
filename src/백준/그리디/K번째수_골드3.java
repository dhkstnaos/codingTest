package 백준.그리디;

import java.io.*;
import java.util.*;
public class K번째수_골드3 {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); long m=sc.nextLong();
        long ans=0;
        long left=1;
        long right=m;
        while(left<=right) {
            long mid=(left+right)/2;
            long count=0;
            for(int i=1;i<=n;i++) {
                count+=Math.min(mid/i,n);
            }
            if(count<m) {
                left=mid+1;
            }
            else {
                ans=mid;
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
}