package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/12738
* 예제 입력
6
10 20 10 30 20 50
* 예제 출력
4
* */
public class 가장긴증가하는부분수열3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE); //초기 값은 그냥 넣는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            int num= Integer.parseInt(st.nextToken());
            if(num>list.get(list.size()-1)) { //list 끝 값보다 크다면 list에 추가
                list.add(num);
            }
            else { //list 안에서 적절한 위치를 찾는다.
                int left=0;
                int right=list.size()-1;
                while(left<right) {
                    int mid=(left+right)/2;
                    if(list.get(mid)<num) {
                        left=mid+1;
                    }
                    else {
                        right=mid;
                    }
                }
                list.set(right,num);
            }
        }
        System.out.println(list.size()-1);
    }
}
