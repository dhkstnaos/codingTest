package 백준.투포인터_슬라이딩윈도우;

import java.util.*;
import java.io.*;
/*
 * https://www.acmicpc.net/problem/1644
 * */
public class 소수의연속합_골드3 {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static boolean[] arr;
    static int n,sum=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        arr = new boolean[n + 1];
        findsosu();
        int s=0; int e=0; int soo=0;
        while(true) {
            if(sum>=n) { //목표 값보다 크거나 같다면 s 인덱스 증가
                sum-=list.get(s);
                s++;
            }
            else if(e==list.size()) break; // list 사이즈 벗어나면 break
            else { //목표 값보다 작다면 e 인덱스 증가
                sum+=list.get(e);
                e++;
            }
            if(sum==n) soo++; // sum이 목표값과 같다면 결과 값증가
        }
        System.out.println(soo);
    }
    static void findsosu() { //에라스토테네스의 체
        //0,1 제외하고 전부 true로 놓고 n 전까지의 i를 증가시키며 배수를 false로 놓고
        //true인 부분만 소수
        if(n<=1) return;
        arr[0]= arr[1]=false;
        for(int i=2;i<=n;i++) {
            arr[i]=true;
        }
        for(int i=2;i*i<=n;i++) {
            for(int j=i*i;j<=n;j+=i) {
                arr[j]=false;
            }
        }
        for(int i=2;i<=n;i++) {
            if(arr[i]==true) {
                list.add(i);
            }
        }
    }
}