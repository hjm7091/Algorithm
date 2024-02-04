package study.cracking_the_coding_interview_6e.array_string.problem1_2;

import java.util.HashMap;
import java.util.Map;

public class MySolution1 {

    public static void main(String[] args) {
        MySolution1 mySolution = new MySolution1();
        boolean result1 = mySolution.isPermutationRelationship("abcdef", "adbfec");
        boolean result2 = mySolution.isPermutationRelationship("abcdefgwk", "adbfecgw");
        System.out.println(result1);
        System.out.println(result2);
    }

    public boolean isPermutationRelationship(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, 1);
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) return false;
        }

        return true;
    }
}
