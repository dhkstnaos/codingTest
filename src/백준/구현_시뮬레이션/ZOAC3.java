package 백준.구현_시뮬레이션;
import java.io.*;
import java.util.*;
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class ZOAC3 {
    static HashMap<Character,Point> left;
    static HashMap<Character,Point> right;
    static int min = Integer.MAX_VALUE;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char sl = st.nextToken().charAt(0), sr = st.nextToken().charAt(0);
        String str = br.readLine();
        make();
        zoac_3(str,sl,sr);
        System.out.println(result);
    }
    public static void make() {
        left = new HashMap<>();
        right = new HashMap<>();
        left.put('q',new Point(0,0));
        left.put('w',new Point(0,1));
        left.put('e',new Point(0,2));
        left.put('r',new Point(0,3));
        left.put('t',new Point(0,4));
        left.put('a',new Point(1,0));
        left.put('s',new Point(1,1));
        left.put('d',new Point(1,2));
        left.put('f',new Point(1,3));
        left.put('g',new Point(1,4));
        left.put('z',new Point(2,0));
        left.put('x',new Point(2,1));
        left.put('c',new Point(2,2));
        left.put('v',new Point(2,3));
        right.put('y',new Point(0,5));
        right.put('u',new Point(0,6));
        right.put('i',new Point(0,7));
        right.put('o',new Point(0,8));
        right.put('p',new Point(0,9));
        right.put('h',new Point(1,5));
        right.put('j',new Point(1,6));
        right.put('k',new Point(1,7));
        right.put('l',new Point(1,8));
        right.put('b',new Point(2,4));
        right.put('n',new Point(2,5));
        right.put('m',new Point(2,6));
    }
    public static void zoac_3(String str,char leftChar, char rightChar){
        for(int i=0;i<str.length();i++){
            if(left.containsKey(str.charAt(i))){
                Point k1 = left.get(leftChar);
                Point k2 = left.get(str.charAt(i));
                result+=(Math.abs(k1.x-k2.x)+Math.abs(k1.y-k2.y));
                result++;
                leftChar = str.charAt(i);
            }
            else{
                Point k1 = right.get(rightChar);
                Point k2 = right.get(str.charAt(i));
                result+=(Math.abs(k1.x-k2.x)+Math.abs(k1.y-k2.y));;
                result++;
                rightChar = str.charAt(i);
            }
        }
    }
}