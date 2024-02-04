package study.cracking_the_coding_interview_6e.array_string.problem1_1;

public class BookSolution2 {

    public static void main(String[] args) {
        BookSolution2 bookSolution = new BookSolution2();
        System.out.println(bookSolution.isUniqueChars("abcdefg"));
        System.out.println(bookSolution.isUniqueChars("abcdeda"));
        System.out.println(bookSolution.isUniqueChars("!)_"));
    }

    public boolean isUniqueChars(String str) {
        int checker = 0;
        for (char c : str.toCharArray()) {
            int value = c - 'a';
            if ((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }

}
