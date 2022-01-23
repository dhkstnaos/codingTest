package 백준.백트래킹;

import java.util.*;
public class NQueen_골드5 {
    public static int[] arr;
    public static int n;	// 체스판의 크기
    public static int count = 0;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        arr=new int[n];
        nQueen(0);
        System.out.println(count);
    }
    public static void nQueen(int depth) {
        if(depth==n) {
            count++;
            return;
        }
        for(int i=0;i<n;i++) {
            arr[depth]=i;
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    public static boolean Possibility(int depth) {
        for(int i=0;i<depth;i++) {
            if(arr[i]==arr[depth]) return false;
            else if(Math.abs(depth-i)==Math.abs(arr[depth]-arr[i])) {
                return false;
            }

        }
        return true;
    }
}