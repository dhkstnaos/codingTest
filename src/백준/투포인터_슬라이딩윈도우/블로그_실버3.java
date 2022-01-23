package 백준.투포인터_슬라이딩윈도우;


import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/21921
 * */
public class 블로그_실버3 { //슬라이딩 윈도우 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int [n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum =0;
        for(int i=0;i<m;i++) {
            sum+= arr[i]; //초기 값 설정
        }
        int ans = sum;
        int cnt =1;
        for(int i= m;i<n;i++) {
            sum += arr[i];
            sum -= arr[i-m];
            if(ans < sum) { //최고 갱신
                ans = sum;
                cnt = 1;
            }
            else if(ans == sum) {
                cnt++;
            }
        }
        if(ans ==0)
        {
            System.out.println("SAD");
        }
        else {
            System.out.println(ans);
            System.out.println(cnt);

        }
    }


}