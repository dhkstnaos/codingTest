package 백준.그리디;

import java.util.*;
public class 검문_골드5 {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);	// 정렬
        int gcdVal = arr[1] - arr[0];
        for(int i=2;i<N;i++) {
            gcdVal=gcd(gcdVal,arr[i]-arr[i-1]);
        }
        for(int i = 2; i <= gcdVal; i++) {
            if(gcdVal % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}