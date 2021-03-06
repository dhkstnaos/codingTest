package 백준.자료구조;

import java.util.*;
import java.io.*;
/*
문자열을 다룰때 커서를 이용한 문제일 때 두 개의 스택을 사용해서 풀 수 있다.
*/
public class 키로거_실버3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int j=0; j<t; j++) {
            char[] str = br.readLine().toCharArray();
            Stack<Character> a1 = new Stack<Character>();
            Stack<Character> a2 = new Stack<Character>();
            for(int i=0; i<str.length; i++) {
                switch(str[i]) {
                    case '<':
                        if(!a2.isEmpty()) {
                            a1.push(a2.pop());
                        }
                        break;
                    case '>':
                        if(!a1.isEmpty()) {
                            a2.push(a1.pop());
                        }
                        break;
                    case '-':
                        if(!a2.isEmpty()) {
                            a2.pop();
                        }
                        break;
                    default:
                        if(str[i] != '<' && str[i] != '>' && str[i] != '-') {
                            a2.push(str[i]);
                        }
                        break;
                }
            }
            while(!a1.isEmpty()) {
                a2.push(a1.pop());
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<a2.size(); i++) {
                sb.append(a2.elementAt(i));
            }
            System.out.println(sb);
        }
    }
}