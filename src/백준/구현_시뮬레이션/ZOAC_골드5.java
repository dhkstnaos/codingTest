package 백준.구현_시뮬레이션;

/*
    문자열에서 가장 사전순으로 앞에 있는 char를 찾고 그 idx를 기준으로
    오른쪽에 있는 문자열 중에서 사전순으로 앞에 있는 문자를 계속해서 찾는다.*/
import java.io.*;
import java.util.*;
public class ZOAC_골드5 {
    static String str;
    static boolean[] visited;
    static StringBuilder sb=new StringBuilder();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        str=st.nextToken();
        visited=new boolean[str.length()];
        dfs(0,str.length()-1);
        System.out.println(sb);
    }
    static void dfs(int left,int right) {
        if(left>right) return;
        int idx=left;
        for(int i=left;i<=right;i++) {
            if(str.charAt(idx)>str.charAt(i)){ //사전순으로 앞이면
                idx=i;
            }
        }
        visited[idx]=true;;
        for(int i=0;i<str.length();i++) {
            if(visited[i]) sb.append(str.charAt(i));
        }
        sb.append("\n");
        dfs(idx+1,right); //끝까지 탐색
        dfs(left,idx-1);
    }
}