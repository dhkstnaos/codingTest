package 백준.완전탐색;
/*
 * https://www.acmicpc.net/problem/2309
 * */
import java.io.*;
        import java.util.*;
public class 일곱난쟁이_브론즈2 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[9]; int sum=0;
        for (int j = 0; j < 9; j++) {
            arr[j] = sc.nextInt();
            sum+=arr[j];
        }
        Arrays.sort(arr);
        for(int i=0;i<9;i++) {
            for(int j=i+1;j<9;j++) {
                if(sum-arr[i]-arr[j]==100) {
                    for(int k=0;k<9;k++) {
                        if(i==k||j==k) continue;
                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}