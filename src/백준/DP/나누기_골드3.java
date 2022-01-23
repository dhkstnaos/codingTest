package 백준.DP;

import java.io.*;
import java.util.*;
/*
count가 몇번째 수인지 나타내며 매 행을 돌면서  +=Math.min(mid/i,n);
*/
public class 나누기_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] num=new long[n];
        long sum=0L;
        int[] cnt=new int[4];
        cnt[0]=1;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            num[i]=Integer.parseInt(st.nextToken());
            sum+=num[i];
        }
        if(sum%4!=0) System.out.println(0);
        else {
            long division=sum/4;
            long pSum=0L;
            for(int i=0;i<n;i++) {
                pSum+=num[i];
                if(pSum==division) {
                    cnt[1]+=cnt[0];
                }
                if(pSum==2*division) {
                    cnt[2]+=cnt[1];
                }
                if(pSum==3*division) {
                    cnt[3]+=cnt[2];
                }
            }
            System.out.println(cnt[3]);
        }
    }
}