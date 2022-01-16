package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_1;

public class BookSolution1 {

    public static void main(String[] args) {
        BookSolution1 bookSolution = new BookSolution1();
        System.out.println(bookSolution.isUniqueChars("abcdefg"));
        System.out.println(bookSolution.isUniqueChars("abcdeda"));
        System.out.println(bookSolution.isUniqueChars("!)_"));
    }

    public boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;
        boolean[] check = new boolean[128];
        for (char c : str.toCharArray()) {
            if (check[c]) {
                return false;
            }
            check[c] = true;
        }
        return true;
    }

}
