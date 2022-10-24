package Baekjoon.KMP.q1786;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        KMP(text, pattern);
    }

    private static void KMP(String text, String pattern) {
        int[] table = table(pattern);
        char[] texts = text.toCharArray();
        char[] patterns = pattern.toCharArray();
        List<Integer> positions = new ArrayList<>();
        int frequency = 0;
        int k = 0;
        for (int i = 0; i < texts.length; i++) {
            while (k > 0 && texts[i] != patterns[k]) {
                k = table[k - 1];
            }
            if (texts[i] == patterns[k]) {
                if (k == patterns.length - 1) {
                    frequency++;
                    positions.add(i - (patterns.length - 2));
                    k = table[k];
                } else {
                    k++;
                }
            }
        }
        System.out.println(frequency);
        System.out.println(positions.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int[] table(String pattern) {
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int k = 0;
        for (int i = 1; i < patterns.length; i++) {
            while (k > 0 && patterns[k] != patterns[i]) {
                k = table[k - 1];
            }
            if (patterns[k] == patterns[i]) {
                table[i] = ++k;
            }
        }
        return table;
    }

}
