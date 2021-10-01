package Baekjoon.BinarySearch.q1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        int K = Integer.parseInt(s[0]), N = Integer.parseInt(s[1]);

        int[] arr = new int[K];
        long max = -1;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            max = Long.max(max, arr[i]);
        }

        max++;
        long min = 0;
        while (min < max) {

            long mid = (min + max) / 2;
            long count = 0;

            for (int a : arr) {
                count += ( a / mid );
            }

//            System.out.println("min : " + min + ", max : " + max);
//            System.out.println("mid : " + mid);
//            System.out.println("count : " + count);
//            System.out.println();

            if (count >= N) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }

}
