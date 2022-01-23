package 백준.완전탐색;

import java.io.*;
/*
 * https://www.acmicpc.net/problem/18111
 * */
public class 마인크래프트_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int b = Integer.parseInt(str[2]);
        int[][] mine = new int[n][m];
        int min = 256;
        int max = 0;
        int Sanswer = Integer.MAX_VALUE;
        int Hanswer = -1 ;
        for (int i = 0; i < mine.length; i++) {
            String[] temp_arr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                mine[i][j] = Integer.parseInt(temp_arr[j]);
                max = Math.max(max, Integer.parseInt(temp_arr[j]));
                min = Math.min(min, Integer.parseInt(temp_arr[j]));
            }
        }
        for (int i = min; i <= max; i++) {
            int second = 0;
            int inven=b;
            for(int j=0;j<mine.length;j++) {
                for(int k=0;k<mine[0].length;k++) {
                    int temp=mine[j][k]-i;
                    if(temp>0) {
                        second+=temp*2;
                        inven+=temp;
                    }
                    else if(temp<0) {
                        second+=Math.abs(temp);
                        inven-=Math.abs(temp);
                    }

                }
            }
            if(inven>=0 && second<=Sanswer){
                Sanswer=second;
                Hanswer=i;
            }

        }
        System.out.println(Sanswer+" "+Hanswer);
    }
}