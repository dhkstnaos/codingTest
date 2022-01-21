package 백준.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/*
* https://www.acmicpc.net/problem/14003
* 예제 입력
6
10 20 10 30 20 50
* 예제 출력
4
10 20 30 50
* */
public class 가장긴증가하는부분수열5 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int[] indexs = new int[n];
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE); //초기 값은 그냥 넣는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            arr[i]= Integer.parseInt(st.nextToken());
            if(arr[i]>list.get(list.size()-1)) { //list 끝 값보다 크다면 list에 추가
                list.add(arr[i]);
                indexs[i]=list.size()-1;
            }
            else { //list 안에서 적절한 위치를 찾는다.
                int left=0;
                int right=list.size()-1;
                while(left<right) {
                    int mid=(left+right)/2;
                    if(list.get(mid)<arr[i]) {
                        left=mid+1;
                    }
                    else {
                        right=mid;
                    }
                }
                list.set(right,arr[i]);
                indexs[i]=right;
            }
        }
        System.out.println(list.size()-1);
        Stack<Integer> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int idx=list.size()-1;
        for(int i=n-1;i>=0;i--) {
            if(indexs[i]==idx) {
                idx--;
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}