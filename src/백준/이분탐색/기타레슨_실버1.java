package 백준.이분탐색;

import java.io.*;
import java.util.*;
public class 기타레슨_실버1 {
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int left=0; int right=0;
        int answer=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
            right+=arr[i];
            left=Math.min(left,arr[i]);
        }
        while(left<=right) {
            int mid=(left+right)>>>1;
            int sum=0; int cnt=0;
            for(int i=0;i<n;i++) {
                if(sum+arr[i]>mid) {
                    sum=0; cnt++; //디스크 개수 증가
                }
                sum+=arr[i];
            }
            if(sum!=0) cnt++; //0이면 이미 개수 증가
            if(cnt<=m) {
                right=mid-1;
            }
            else {
                left=mid+1;
                answer=Math.max(answer,left);
            }
        }
        System.out.println(answer);
    }
}