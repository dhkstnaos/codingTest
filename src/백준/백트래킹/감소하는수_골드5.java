package 백준.백트래킹;

import java.util.*;
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
    //1~9를 리스트에 추가하고 감소하는 수를 추가한다.
    public static void bp(long num, int idx) {
        if(idx > 10) return;
        list.add(num);
        for(int i = 0; i < num % 10; i++) { // %10으로 감소 확인
            bp((num * 10) + i, idx + 1);
        }
    }
}