package baekjoon.implementation.q1475;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int[] num = new int[10];
        for (char c : n.toCharArray()) {
            num[Integer.parseInt(String.valueOf(c))]++;
        }
        int maxFreq = ((num[6] + num[9]) / 2) + ((num[6] + num[9]) % 2);
        for (int i = 0; i < num.length; i++) {
            if (i == 6 || i == 9) continue;
            if (num[i] > maxFreq) {
                maxFreq = num[i];
            }
        }
        System.out.println(maxFreq);
    }

}
