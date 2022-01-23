package 백준.구현_시뮬레이션;
import java.io.*;
import java.util.*;
public class 스위치켜고끄기_실버4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< N ; i++) {
            arr[i] = st.nextToken().contains("1")?true:false;
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i< M ;i++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken())==1) { //남자
                int m = Integer.parseInt(st.nextToken());
                for(int j = m-1; j<N; j+=m) {
                    arr[j]= !arr[j];
                }
            }
            else {
                int w = Integer.parseInt(st.nextToken())-1;
                arr[w] = !arr[w];
                int length = 1;
                while(w-length>=0 && w+length<N) {
                    if(arr[w-length]==arr[w+length]) {
                        arr[w-length]=!arr[w-length];
                        arr[w+length]=!arr[w+length];
                    }else {
                        break;
                    }
                    length++;
                }
            }
        }
        for(int i =0; i< N; i++) {
            System.out.print(arr[i] ? "1 ":"0 ");
            if(i%20==19)System.out.println();
        }
    }
}