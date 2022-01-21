package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
/*
* https://www.acmicpc.net/problem/2251
* 예제 입력
8 9 10
* 예제 출력
* : 1 2 8 9 10
* */
class Node{
    int a,b,c;
    Node(int a, int b ,int c){
        this.a=a; this.b=b; this.c=c;
    }
}
public class 물통_실버1 {
    static boolean[][][] visited;
    static int max_a,max_b,max_c;
    static ArrayList<Integer> list = new ArrayList<>();
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t =br.readLine().split(" ");
        max_a = Integer.parseInt(t[0]);
        max_b = Integer.parseInt(t[1]);
        max_c = Integer.parseInt(t[2]);
        visited = new boolean[max_a+1][max_b+1][max_c+1];
        q.add(new Node(0,0,max_c));
        bfs();
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
    public static void bfs() {
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(visited[node.a][node.b][node.c]) {
                continue;
            }
            if(node.a==0) {
                list.add(node.c);
            }
            visited[node.a][node.b][node.c] = true;
            //b->a
            if(node.a+node.b<=max_a) {
                q.add(new Node(node.a+node.b,0,node.c));
            }
            else {
                q.add(new Node(max_a,node.b+node.a-max_a,node.c));
            }

            //c->a
            if(node.a+node.c<=max_a) {
                q.add(new Node(node.a+node.c,node.b,0));
            }
            else {
                q.add(new Node(max_a,node.b,node.c+node.a-max_a));
            }

            //a->b
            if(node.b+node.a<=max_b) {
                q.add(new Node(0,node.a+node.b,node.c));
            }
            else {
                q.add(new Node(node.a+node.b-max_b,max_b,node.c));
            }

            //c->b
            if(node.b+node.c<=max_b) {
                q.add(new Node(node.a,node.b+node.c,0));
            }
            else {
                q.add(new Node(node.a,max_b,node.c+node.b-max_b));
            }

            //a->c
            if(node.c+node.a<=max_c) {
                q.add(new Node(0,node.b,node.c+node.a));
            }
            else {
                q.add(new Node(node.a+node.c-max_c,node.b,max_c));
            }

            //b->c
            if(node.c+node.b<=max_c) {
                q.add(new Node(node.a,0,node.c+node.b));
            }
            else {
                q.add(new Node(node.a,node.b+node.c-max_c,max_c));
            }
        }
    }
}
