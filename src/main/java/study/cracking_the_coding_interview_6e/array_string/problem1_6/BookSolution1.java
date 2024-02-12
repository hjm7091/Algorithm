package study.cracking_the_coding_interview_6e.array_string.problem1_6;

public class BookSolution1 {

    public static void main(String[] args) {
        BookSolution1 solution = new BookSolution1();
        System.out.println(solution.compress("aabccccaaa"));
        System.out.println(solution.compress("aa"));
        System.out.println(solution.compress("ab"));
    }

    public String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

}
