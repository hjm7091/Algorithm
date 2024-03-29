package study.cracking_the_coding_interview_6e.array_string.problem1_5;

public class BookSolution2 {

    public static void main(String[] args) {
        BookSolution2 solution = new BookSolution2();
        System.out.println(solution.oneEditAway("pale", "ple"));
        System.out.println(solution.oneEditAway("pales", "pale"));
        System.out.println(solution.oneEditAway("pale", "bale"));
        System.out.println(solution.oneEditAway("pale", "bake"));
    }

    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }

        return true;
    }

}
