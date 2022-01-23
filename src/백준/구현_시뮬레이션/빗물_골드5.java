package 백준.구현_시뮬레이션;

/*
    빗물이 담기려면 가장 좌측과 우측은 계산에서 제외해야 한다.
        1~w-1 인덱스를 거치면서 해당 인덱스의 좌측,우측에서의 가장 큰 값을 찾는다.
        찾은 값 중 작은 값을 계산 높이로 정하고 계산 높이가 해당 인덱스의
        숫자보다 크다면 높이에서 숫자를 빼주고 결과 값에 더해준다.
        시간 복잡도 $N^2$ n은 500밖에 되지않아 계산이 빠르게 된다.*/
import java.io.*;
import java.util.*;
public class 빗물_골드5 {
    static int odd_max=Integer.MIN_VALUE,odd_min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int[] rain=new int[w];
        int result=0;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++) {
            rain[i]=Integer.parseInt(st.nextToken());
        }
        int height,left,right,idx;
        for(int i=1;i<w-1;i++) {
            left=0; right=0; height=0;
            idx=i-1;
            while(idx>=0) {
                left=Math.max(left,rain[idx]);
                idx--;
            }
            idx=i+1;
            while(idx<w) {
                right=Math.max(right,rain[idx]);
                idx++;
            }
            height=Math.min(left,right);
            if(height>rain[i]) {
                result+=height-rain[i];
            }
        }
        System.out.println(result);
    }
}