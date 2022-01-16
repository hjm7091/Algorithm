package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_2;

import java.util.Arrays;

public class BookSolution2 {

    public static void main(String[] args) {
        BookSolution2 bookSolution = new BookSolution2();
        boolean result3 = bookSolution.permutation("abcdef", "adbfec");
        boolean result4 = bookSolution.permutation("abcdefgwk", "adbfecgw");
        System.out.println(result3);
        System.out.println(result4);
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
