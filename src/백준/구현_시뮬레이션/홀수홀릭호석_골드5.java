package 백준.구현_시뮬레이션;

import java.io.*;
/*
한 번의 연산
1.각 자리 숫자 중 홀수의 개수를 따로 뺀다
2. 한 자리이면 그만한다.
3. 두자리면 2개로 나눠 합을 구해 새로운 수로 생각한다.
4. 세자리 이상이면 임의의 위치에서 끊어 세수로 분할한다.
*/
public class 홀수홀릭호석_골드5 {
    static int odd_max=Integer.MIN_VALUE,odd_min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        backTracking(n,0);
        System.out.println(odd_min+" "+odd_max);
    }
    public static void backTracking(int num,int cnt) {
        String num_str=String.valueOf(num);
        int length=num_str.length();
        for(int i=0;i<length;i++) {
            if((num_str.charAt(i)-'0')%2==1) cnt++;
        }
        int tmp=0;
        if(length==1) {
            odd_max=Math.max(odd_max,cnt);
            odd_min=Math.min(odd_min,cnt);
            return;
        }
        else if(length==2) {
            tmp+=num_str.charAt(0)-'0'+num_str.charAt(1)-'0';
            backTracking(tmp,cnt);
        }
        else {
            for(int i=1;i<length-1;i++) {
                for(int j=i+1;j<length;j++) {
                    tmp=0;
                    tmp+=Integer.parseInt(num_str.substring(0,i))+
                            Integer.parseInt(num_str.substring(i,j))+
                            Integer.parseInt(num_str.substring(j,length));
                    backTracking(tmp,cnt);
                }
            }
        }
    }
}