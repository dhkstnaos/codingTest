package 백준.자료구조;
/*
    n이 최대 100000
        분할정복으로 풀 때 n^2으로 시간 초과 난다.
        스택으로 최소값만 갱신해주면서 답을 구한다.
        최댓값에서 최소값을 뺀다.
        예시: 6 / 1 3 2 1 6 4
        i=0 stack=[1] result=0
        i=1 stack=[3] result=2 / stack.peek()<t이다.
        i=2 stack=[2] result=2 / stack.peek()>t 최소값 갱신
        i=3 stack=[1] result=2 / stack.peek()>t 최소값 갱신
        i=4 stack=[6] result=7 / stack.peek()<t이다.
        i=5 stack=[4] result=7 / stack.peek()>t 최소값 갱신
        stack=[4] max=6 result=7
        result에 max-stack.pop()
        result 7+(6-4)=9가 된다.
        1→3으로 가는 경우 차 만큼 result에 값을 넣어주는 방식 3 3이 된다.
stack에는 최소값만 들어가게 되는데 peek()보다 작은 값이 들어온다면 pop을 하고 값을 추가 해주었다.
*/
import java.io.*;
import java.util.*;
public class 같은수로만들기2_플레5 {
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