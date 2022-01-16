package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_2;

public class BookSolution1 {

    public static void main(String[] args) {
        BookSolution1 bookSolution = new BookSolution1();
        boolean result3 = bookSolution.permutation("abcdef", "adbfec");
        boolean result4 = bookSolution.permutation("abcdefgwk", "adbfecgw");
        System.out.println(result3);
        System.out.println(result4);
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (char c : t.toCharArray()) {
            letters[c]--;
            if (letters[c] < 0) return false;
        }

        return true;
    }

}
