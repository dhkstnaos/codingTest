package 백준.자료구조;

import java.io.*;
import java.util.*;
public class 같은수로만들기_골드4 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long result=0L;
        int max=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++) {
            int t=Integer.parseInt(br.readLine());
            max=Math.max(t,max);
            if(stack.isEmpty()) {
                stack.push(t);
            }
            else {
                if(stack.peek()<t) {
                    result+=t-stack.pop();
                    stack.push(t);
                }
                else if(stack.peek()>t) {
                    stack.pop();
                    stack.push(t);
                }
            }
        }
        result+=max-stack.pop();
        System.out.println(result);
    }
}