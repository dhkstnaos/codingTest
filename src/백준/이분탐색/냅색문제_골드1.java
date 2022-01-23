package 백준.이분탐색;
import java.io.*;
import java.util.*;
/*
N이 최대 30으로 완전 탐색으로는 2^30=10억 그러나 이분탐색으로 계산하면 2^15*2= 64000이다.
반으로 나눠 만들 수 있는 무게를 list 배열에 담는다. 배열을 정렬 시키고 최대의 인덱스를 찾는다.
 왜냐하면 right는 정렬되어 있기 때문에 0부터 해당 인덱스까지는
 left의 i번쨰와 더해도 C 이하이기 때문이다.
*/
public class 냅색문제_골드1 {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        dfs(0, N/2, 0, left);
        dfs(N/2+1, N-1, 0, right);
        Collections.sort(left);
        Collections.sort(right);
        int result = 0;
        int e = right.size() - 1;
        for(int i = 0; i < left.size(); i++){
            while(e >= 0 && left.get(i)+right.get(e) > C){
                e--;
            }
            result += e+1;
        }
        System.out.println(result);
    }
    public static void dfs(int st, int end, int sum, ArrayList<Integer> list){
        if(sum > C) return;
        if(st > end) { //부분 선택한 sum 값이 들어오게 된다.
            list.add(sum);
            return;
        }
        dfs(st+1, end, sum, list); //무게를 더했을 경우
        dfs(st+1, end, sum + arr[st], list); //더하지 않은 경우
    }

}