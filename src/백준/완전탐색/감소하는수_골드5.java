package 백준.완전탐색;


import java.util.*;
/*
 * https://www.acmicpc.net/problem/1038
 * N의 자리수가 1,000,000이기 때문에
 * 완전탐색으로 풀면 무조건 시간 초과가 날것이다.
 * list에는 무조건 감소하는 수만 들어간다.
 * */
public class 감소하는수_골드5 {
    static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        list = new ArrayList<>();
        if(n > 1022) System.out.println("-1");
        else if(n <= 10) System.out.println(n);
        else {
            for(int i = 0; i < 10; i++) {
                bp(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    public static void bp(long num, int idx) {
        if(idx > 10) return;
        list.add(num);
        for(int i = 0; i < num % 10; i++) {
            bp((num * 10) + i, idx + 1);
        }
    }
}