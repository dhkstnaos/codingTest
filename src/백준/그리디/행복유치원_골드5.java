package 백준.그리디;

import java.io.*;
import java.util.*;
/*
        5 3
        1 3 5 6 10
        2 2 1 4 --> 1 2 2 4
        출력 :3

        7 3 h-w=4
        1 2 3 4 5 6 7 (1~4) (5~6) 7
        1 1 1 1 1 1

        6 4 =2
        1 4 5 9 15 20
        3 1 4 6  5  1-3-4-5-6
        (4~5)(1~4) = (1~5),(9),(15),(20)
인접한 것만 가능하다. 3~6을 조로 선택해도 6-5+5-3과 차이가 같다.
 앞 지점과의 차이를 구한 후에 배열을 정렬한다. 정렬한 후에 차이가 적은*/
public class 행복유치원_골드5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int[] kid=new int[h];
        int[] dif=new int[h-1];
        int fix=0;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<h;i++) {
            int tmp=Integer.parseInt(st.nextToken());
            kid[i]=tmp;
        }
        for(int i=0;i<h-1;i++) {
            dif[i]=kid[i+1]-kid[i];
        }
        Arrays.sort(dif);
        for(int i=0;i<h-w;i++) {
            fix+=dif[i];
        }
        System.out.println(fix);
    }
}