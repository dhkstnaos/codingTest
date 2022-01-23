package 백준.백트래킹;
import java.util.Arrays;
import java.util.Scanner;
public class 차이를최대로_실버2 {
    static int n ;
    static int[] arr;
    static int result;
    static int[]  tArr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n =  sc.nextInt();
        arr =new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] =sc.nextInt();
        }
        visited =new boolean[n];
        tArr =new int[n];
        result=0;
        solve(0);
        System.out.println(result);
    }
    private static void solve(int count){
        if(count == n){
            int sum =0;
            for (int i = 0; i <n-1 ; i++) {
                sum += Math.abs(tArr[i] - tArr[i+1]);
            }
            result = Math.max(result,sum);
            return;
        }
        for (int i = 0; i <n ; i++) {
            if(!visited[i]){
                visited[i] =true;
                tArr[count] = arr[i];
                solve(count+1);
                visited[i] =false;
            }
        }
    }
}