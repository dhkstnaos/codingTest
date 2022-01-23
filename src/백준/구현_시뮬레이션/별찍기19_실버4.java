package 백준.구현_시뮬레이션;

import java.io.*;
import java.util.*;
public class 별찍기19_실버4 {
    static boolean[][] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int size = 4*n -3;
        s = new boolean[size][size];
        print(0,0,size);
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                sb.append(s[i][j]?"*":" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void print(int x, int y, int size) {
        if(size<0) return;
        for(int i=0;i<size;i++) {
            s[x][y+i] = true;
            s[x+size-1][y+i] = true;
            s[x+i][y] = true;
            s[x+i][y+size-1] = true;
        }
        print(x+2,y+2,size-4);
    }
}