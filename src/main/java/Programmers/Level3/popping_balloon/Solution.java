package Programmers.Level3.popping_balloon;

import java.util.*;

// 참고 : https://moonsbeen.tistory.com/180
class Solution {

    public int solution(int[] a) {
        int[] leftMin = new int[a.length]; //각 인덱스에서 왼쪽 원소의 최소값을 저장
        int[] rightMin = new int[a.length]; //각 인덱스에서 오른쪽 원소의 최대값을 저장
        int l = a[0]; //왼쪽 값 중 최소값
        int r = a[a.length - 1]; //오른쪽 값 중 최소값

        //i일때 왼쪽 원소의 최소값을 저장
        for(int i = 1; i < a.length - 1; i++) {
            if(l > a[i]) l = a[i];
            leftMin[i] = l;
        }
        //i일때 오른쪽 원소의 최소값을 저장
        for(int i = a.length - 2; i > 0; i--) {
            if(r > a[i]) r = a[i];
            rightMin[i] = r;
        }

//        System.out.println(Arrays.toString(leftMin));
//        System.out.println(Arrays.toString(rightMin));

        if (a.length == 1) return 1;
        int answer = 2;
        for (int i = 1; i < a.length - 1; i++) {
            if (leftMin[i] < a[i] && a[i] > rightMin[i]) continue;
            answer++;
        }
        return answer;
    }
}
