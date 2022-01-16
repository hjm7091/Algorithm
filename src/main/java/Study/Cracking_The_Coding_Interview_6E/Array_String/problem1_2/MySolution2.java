package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_2;

import java.util.Arrays;

public class MySolution2 {

    public static void main(String[] args) {
        MySolution2 mySolution = new MySolution2();
        boolean result1 = mySolution.isPermutationRelationship("abcdef", "adbfec");
        boolean result2 = mySolution.isPermutationRelationship("abcdefgwk", "adbfecgw");
        System.out.println(result1);
        System.out.println(result2);
    }

    public boolean isPermutationRelationship(String str1, String str2) {

        if (str1.length() != str2.length()) return false;

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }

        return true;
    }
}
