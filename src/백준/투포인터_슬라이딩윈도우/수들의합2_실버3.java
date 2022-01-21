package 백준.투포인터_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://www.acmicpc.net/problem/2003
 * */
public class 수들의합2_실버3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        st=new StringTokenizer(br.readLine().trim()); //빈 칸을 제거
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine().trim());
        int[] A = new int[N];
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int sidx=0;
        int eidx=0;
        int sum=0; //합이 m일때 계산
        int rst=0; //경우의 수
        while(true) {
            if (sum >= M) sum -= A[sidx++];
            else if(eidx > N - 1) break;
            else sum += A[eidx++];
            if(sum == M) {
                rst++;
            }
        }
        System.out.println(rst);
    }
}