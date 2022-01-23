package 백준.이분탐색;

import java.io.*;
import java.util.*;
/*
입력
        6
        10 20 1 2 3 4
        10 [0 10]
        20 [0 10 20]
        1   [0  1  20]
        2   [0  1   2]
        3   [0  2   3]
        4   [0  2   4]
        answer = list.size()-1
*/
public class 가장긴증가하는부분수열2_골드2 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        int[] arr=new int[n+1];
        list.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //이전에 입력받은 값 보다 큰 수를 입력받은 경우
            if(arr[i]>list.get(list.size()-1)) {
                list.add(arr[i]);
            }
            else {
                //이전에 입력받은 값 보다 작거나 같은 수를 입력받은 경우
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
            }
        }
        System.out.println(list.size()-1);
    }
}