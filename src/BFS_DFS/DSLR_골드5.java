package BFS_DFS;

import java.util.*;
import java.io.*;
/*
* https://www.acmicpc.net/problem/9019
* 예제 입력
3
1234 3412
1000 1
1 16
* 예제 출력
LL
L
DDDD
* */
public class DSLR_골드5 {
        static int a,b;
        static boolean[] visited;
        static String[] cmd;
        public static void main(String[] args) throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            while(t-->0) {
                visited=new boolean[10000];
                cmd=new String[10000];
                Arrays.fill(cmd,""); //빈 문자열로 채움
                String[] splited=br.readLine().split(" ");
                a=Integer.parseInt(splited[0]);
                b=Integer.parseInt(splited[1]);
                System.out.println(bfs());
            }
        }
        public static String bfs() {
            Queue<Integer> q=new LinkedList<>();
            q.add(a); //큐에 처음 숫자를 추가합니다.
            visited[a]=true; // 방문 표시를 남깁니다.
            while(!q.isEmpty()) {
                int now=q.poll();
                int d=(now*2)%10000;
                int s=(now==0) ? 9999 : now-1;
                int l=(now%1000) * 10 + now/1000;
                int r=(now%10)* 1000 + now/10;
                if(!visited[d]) {
                    q.add(d);
                    visited[d]=true;
                    cmd[d]=cmd[now]+"D";
                }
                if(!visited[s]) {
                    q.add(s);
                    visited[s]=true;
                    cmd[s]=cmd[now]+"S";
                }
                if(!visited[l]) {
                    q.add(l);
                    visited[l]=true;
                    cmd[l]=cmd[now]+"L";
                }
                if(!visited[r]) {
                    q.add(r);
                    visited[r]=true;
                    cmd[r]=cmd[now]+"R";
                }
            }
            return cmd[b]; //가장 먼저 도달한 명령어가 자리하게 된다.
        }
    }