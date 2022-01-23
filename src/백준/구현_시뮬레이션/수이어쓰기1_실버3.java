package 백준.구현_시뮬레이션;

import java.util.Scanner;
public class 수이어쓰기1_실버3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        int cnt=1;
        int temp=0;
        int length=10;
        for(int i=1;i<=number;i++) {
            if(i==length) {
                cnt++;
                length=length*10;
            }
            temp= temp+cnt;
        }
        System.out.println(temp);
    }

}