package study.cracking_the_coding_interview_6e.array_string.problem1_9;

public class BookSolution {

    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            return isSubString(s1 + s1, s2);
        }
        return false;
    }

    private boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        BookSolution solution = new BookSolution();
        boolean result1 = solution.isRotation("erbottlewat", "waterbottle");
        boolean result2 = solution.isRotation("erbottlewat", "waterobttle");
        System.out.println(result1);
        System.out.println(result2);
    }
}
