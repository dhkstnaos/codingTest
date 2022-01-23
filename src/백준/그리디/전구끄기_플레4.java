package 백준.그리디;

/*
    전구를 누르게 되면 상하좌우,자기 자신의 전구들의 상태가 바뀌게 된다.
        완전 탐색 이용시 최대 2^(18*18)개의 조합이 되어 시간 초과가 나게 된다.
        해당 위치의 스위치를 단 한번만 누른다고 가정하고 첫 행에서 나올 수 있는 가짓수를 조합해본다.
        최대 2^18가지가 나올 수 있으며 다음 행부터는 바로 위 전구가 켜져 있는 상태일때만 전구를 꺼주기
        위해 전구 상태를 바꾼다. 시간복잡도는 최대 2^18*18*18된다.
        조합에는 비트 마스크를 이용하고 새 조합을 짤 때마다 새로운 배열을 생성하고 원래 배열을 복사해주었다.
        마지막 행에서 전구가 모두 꺼져 있다면 다른 전구들은 확인할 필요가 없다.*/
import java.io.*;
import java.util.*;
public class 전구끄기_플레4 {
    static boolean[][] tmp,switches;
    static int n;
    static void copy() {
        for(int i=0;i<n;i++) {
            tmp[i]=switches[i].clone();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        switches=new boolean[n][n];

        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                int c=Integer.parseInt(st.nextToken());
                switches[i][j]= c==1 ? true : false;
            }
        }
        int min=Integer.MAX_VALUE;
        int cnt;
        for(int i=0;i<(1<<n);i++) {
            tmp=new boolean[n][n];
            copy();
            cnt=0;
            for(int j=0;j<n;j++) {
                if((i&(1<<j))!=0) { // 비트가 켜져 있다면
                    turn(0,j);
                    cnt++;
                }
            }
            for(int a=1;a<n;a++) {
                for(int b=0;b<n;b++) {
                    if(tmp[a-1][b]==true) {
                        turn(a,b);
                        cnt++;
                    }
                }
            }
            boolean pass=true;
            for(int l=0;l<n;l++) {
                if(tmp[n-1][l]==true) {
                    pass=false;
                    break;
                }
            }
            if(pass) min=Math.min(min,cnt);
        }
        min= min==Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }
    public static void turn(int x,int y) {
        tmp[x][y]=!tmp[x][y];
        if(x!=0) tmp[x-1][y]=!tmp[x-1][y]; //상
        if(x!=n-1) tmp[x+1][y]=!tmp[x+1][y];
        if(y!=0) tmp[x][y-1]=!tmp[x][y-1];
        if(y!=n-1) tmp[x][y+1]=!tmp[x][y+1];
    }
}