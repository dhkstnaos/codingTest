package 백준.이분탐색;
import java.io.*;
import java.util.*;
/*
하나를 잡고 나머지 두 숫자를 투 포인터로 돌려서 답을 도출해낸다.
시간 복잡도 O(n^2)으로 해결
*/
public class 세용액_골드4 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr=new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long num1=0;
        long num2=0;
        long num3=0;
        int s;
        int e;
        long sum;
        long max=3000000000L;
        for(int i=0;i<n-2;i++) {
            s=i+1;
            e=n-1;
            while(s<e) {
                sum=arr[i]+arr[s]+arr[e];
                if(Math.abs(sum)<max) {
                    num1=arr[i];
                    num2=arr[s];
                    num3=arr[e];
                    max=Math.abs(sum);
                }
                if(sum>0) e--;
                else s++;
            }
        }
        System.out.println(num1+" "+num2+" "+num3);
    }
}