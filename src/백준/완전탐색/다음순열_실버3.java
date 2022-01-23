package 백준.완전탐색;

import java.util.*;
/*
 * https://www.acmicpc.net/problem/10972
 * */
public class 다음순열_실버3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        if(next_perm(arr)){
            for(int i = 0 ; i < n ; i++){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println(-1);
        }
    }
    public static boolean next_perm(int[] arr){ // 다음 순열로 변경시켜줌 & 다음 순열의 존재여부 반환
        int i = arr.length - 1; // 끝부터 탐색한다
        while( i > 0 && arr[i-1] > arr[i]){ // 앞쪽으로 쭉 탐색하면서 언제부터 내림차순이 안먹히는지 찾는다
            //(이전순열의 경우 부등호 체인지)
            i--;
        }
        if( i <= 0 ){ // 맨앞까지 갔는데도 내림차순이라고? (예 : 54321 ) -> 이건 마지막 순열임
            return false; // 따라서 다음순열 없음(false) 반환
        }
        int j = arr.length-1; // j : i-1 번째 원소와 바꿔치기 할 뒷 파트의 원소. 마찬가지로 끝부터 탐색한다
        while(arr[j] < arr[i-1] ){ // arr[i-1] 보다 크면서 & 뒷파트에서 가장 꼬붕인 애를 찾는것임
            j--;                    // (이전순열의 경우 부등호 체인지)
        }
        // 바꿨으면 둘이 자리 바꿔준다
        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;
        // 뒷파트 애들은 이제 오름차순으로 바꿔줘야한다.
        // 다만 얘네들은 원래 내림차순으로 되어있던 애들이라, 단순히 데칼코마니만 해줘도 오름차순으로 변경 가능함
        int k = arr.length-1;
        while( i < k ){
            temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
            i++;
            k--;
        }
        return true;
    }
}