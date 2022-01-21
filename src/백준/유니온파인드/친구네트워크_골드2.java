package 백준.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
* https://www.acmicpc.net/problem/4195
* 예제 입력
2
3
Fred Barney
Barney Betty
Betty Wilma
3
Fred Barney
Betty Wilma
Barney Betty
* 예제 출력
2
3
4
2
2
4
* */
public class 친구네트워크_골드2 {
    static int[] parent;
    static int[] level;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        int test=Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int testcase=0;testcase<test;testcase++) {
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            parent = new int[t * 2];
            level = new int[t * 2];
            for (int i = 0; i < t * 2; i++) {
                parent[i] = i; level[i] = 1;
            }
            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i=0;i<t;i++) {
                st=new StringTokenizer(br.readLine());
                String a=st.nextToken();
                String b=st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, idx++);  //문자열에 인덱스를 심는다.
                }
                if (!map.containsKey(b)) { //문자열에 인덱스를 심는다.
                    map.put(b, idx++);
                }
                sb.append(union(map.get(a), map.get(b)) + "\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int x) {
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
    public static int union(int x,int y){
        x=find(x); y= find(y);
        if(x!=y) {
            parent[y]=x;
            level[x]+=level[y]; //x를 루트로 둔다.
        }
        return level[x];
    }
}