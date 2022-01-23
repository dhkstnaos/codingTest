package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * https://www.acmicpc.net/problem/2304
 * - 문제 설명

N 개의 막대 기둥이 일렬로 세워져 있다. 기둥들의 폭은 모두 1 m이며 높이는 다를 수 있다.
*  이 기둥들을 이용하여 양철로 된 창고를 제작하려고 한다. 창고에는 모든 기둥이 들어간다.
* 이 창고의 지붕을 다음과 같이 만든다.
1. 지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
2. 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
3. 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
4. 지붕의 가장자리는 땅에 닿아야 한다.
5. 비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.
그림 1은 창고를 옆에서 본 모습을 그린 것이다. 이 그림에서 굵은 선으로 표시된 부분이 지붕에 해당되고,
* 지붕과 땅으로 둘러싸인 다각형이 창고를 옆에서 본 모습이다. 이 다각형을 창고 다각형이라고 하자.
* 왼쪽에서부터 증가하는 값만 리스트에 담고 오른쪽에서도 증가하는 수만 리스트에 담고
 * 이전 x 값을 빼고 이전 x의 높이를 값을 더한다. 추가적으로 중간의 높이가 같을 수
 * 있기때문에 추가적으로 더해준다.
 * * */
public class 창고다각형_실버2{
    public static class cols implements Comparable<cols>{
        int x;
        int h;
        public cols(int x, int h) {
            super();
            this.x = x;
            this.h = h;
        }
        @Override
        public int compareTo(cols o) {
            // TODO Auto-generated method stub
            return this.x-o.x;
        }
    }
    static int n;
    static ArrayList<cols> divr,divl,num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num=new ArrayList<cols>();
        divr=new ArrayList<cols>();
        divl=new ArrayList<cols>();
        for(int i=0;i<n;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            num.add(new cols(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(num);
        for(int i=0;i<n;i++) {
            if(divr.isEmpty()||divr.get(divr.size()-1).h<num.get(i).h) {
                divr.add(num.get(i));
            }
        }
        for(int i=n-1;i>=0;i--) {
            if(divl.isEmpty()||divl.get(divl.size()-1).h<num.get(i).h) {
                divl.add(num.get(i));
            }
        }
        int result=0;
        for(int i=1;i<divr.size();i++) {
            result+=(divr.get(i).x-divr.get(i-1).x)*divr.get(i-1).h;
        }
        for(int i=1;i<divl.size();i++) {
            result+=(divl.get(i-1).x-divl.get(i).x)*divl.get(i-1).h;
        }
        result+=(divl.get(divl.size()-1).x-divr.get(divr.size()-1).x)*divr.get(divr.size()-1).h;
        result+=divr.get(divr.size()-1).h;
        System.out.println(result);
    }

}