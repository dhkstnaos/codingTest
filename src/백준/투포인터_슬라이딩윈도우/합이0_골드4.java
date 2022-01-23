package 백준.투포인터_슬라이딩윈도우;

import java.io.*;
import java.util.*;
/*
최악의 경우 10000C3으로 10000*9999*9998/6으로  경우의 수가 int 범위를 넘어설 수 있다.
long 타입으로 선언해야 오류가 나지 않는다. 음수도 있으니 20001로 선언해준다.숫자 세 개를
 선택하기 위해 숫자 하나를 잡고 나머지 숫자를 투 포인터로 계산한다.
*/
public class 합이0_골드4 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count=new int[20001];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[10000+arr[i]]++;
        }
        Arrays.sort(arr);
        int s;
        int e;
        long result=0L;
        for(int i=0;i<n-2;i++) {
            s=i+1;
            e=n-1;
            while(s<e) {
                int sum=arr[i]+arr[s]+arr[e];
                if(sum==0) {
                    if(arr[s]==arr[e]) {
                        result+=e-s;
                    }
                    else {
                        result+=count[10000+arr[e]];
                    }
                    s++;
                }
                else if(sum>0) e--;
                else s++;
            }
        }
        System.out.println(result);
    }
}