package 백준.문자열.트라이;

import java.io.*;
import java.util.*;
class Node {
    TreeMap<String, Node> childs = new TreeMap<>();
}
//TreeMap으로 Key 값을 자동 정렬
public class 개미굴_골드2 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node root = new Node();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            Node now = root;
            for(int j=0; j<size; j++){
                String tmp = st.nextToken();
                if(!now.childs.containsKey(tmp)){
                    now.childs.put(tmp, new Node());
                }
                now = now.childs.get(tmp);
            }
        }
        print(root, "");
    }
    public static void print(Node root, String bar){
        for (Object s : root.childs.keySet()){
            System.out.println(bar+s);
            print(root.childs.get(s),bar+"--");
        }
    }
}