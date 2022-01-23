package 백준.구현_시뮬레이션;

import java.util.*;
import java.io.*;
public class 삼각형외우기_브론즈4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int c=Integer.parseInt(br.readLine());
        if(a==60&&b==60&&c==60) {
            System.out.println("Equilateral");
        }
        else if((a+b+c)==180) {
            if(a!=b&&b!=c&&a!=c) {
                System.out.println("Scalene");
            }
            else {
                System.out.println("Isosceles");
            }
        }
        else {
            System.out.println("Error");
        }
    }
}