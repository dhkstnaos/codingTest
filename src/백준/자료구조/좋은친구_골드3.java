package 백준.자료구조;
import java.io.*;
import java.util.*;
public class 좋은친구_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        long cnt = 0;
        Queue<Integer>[] q = new Queue[21]; //우선순위큐를 21개 배열 생성
        for (int i = 2; i <= 20; i++) { //2글자 ~ 20
            q[i] = new LinkedList<>();
        }
        for(int i=0;i<n;i++) {
            int leng=br.readLine().length(); //길이만 빼온다.
            if(q[leng].isEmpty()) { //비어있으면 큐에 추가
                q[leng].add(i); //큐에 추가
                continue;
            }
            while(i-q[leng].peek()>k) {
                q[leng].poll();
                if(q[leng].isEmpty()) break;
            }
            cnt+=q[leng].size();
            q[leng].add(i);
        }
        System.out.println(cnt);
    }
}