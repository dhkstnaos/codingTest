package 백준.자료구조;

import java.io.*;
import java.util.*;
public class 탑_골드5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Stack<int []> st=new Stack<>();
        int idx=n;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(stk.nextToken());
            while (!st.isEmpty()) {
                if (st.peek()[1] >= v) {
                    System.out.print(st.peek()[0] + " ");
                    break;
                }
                st.pop();
            }
            if (st.isEmpty()) {
                System.out.print("0 ");
            }
            st.push(new int[] { i, v });
        }
    }
}