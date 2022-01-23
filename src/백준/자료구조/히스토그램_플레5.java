package 백준.자료구조;
import java.util.*;
import java.io.*;
public class 히스토그램_플레5 {
    static int[] arr;
    static Stack<Integer> stack=new Stack<>();
    public static void main(String args[])  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(histogram(N));
        }
    }
    static long histogram(int len) {
        long maxArea=0;
        for(int i=0;i<len;i++) {
            while((!stack.isEmpty())&&arr[stack.peek()]>=arr[i]) {
                //스택이 비어 있지않고 스택의 peek의 arr 값이 해당 arr[i] 값 보다 작거나 같을때
                int height=arr[stack.pop()]; //height는 arr[peek()];
                long width=stack.isEmpty() ? i : i-stack.peek()-1;
                //스택이 비어있다면 i까지가 폭이 된다.
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) { //남은 큐들을 정리
            int height=arr[stack.pop()];
            long width=stack.isEmpty() ? len : len-stack.peek()-1;
            maxArea=Math.max(maxArea,height*width);
        }
        return maxArea;
    }
}