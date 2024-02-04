package study.cracking_the_coding_interview_6e.array_string.problem1_5;

public class MySolution {

    public static void main(String[] args) {
        MySolution solution = new MySolution();
        System.out.println(solution.isPossibleToCreateTheSameStringWithinOneEdit("pale", "ple"));
        System.out.println(solution.isPossibleToCreateTheSameStringWithinOneEdit("pales", "pale"));
        System.out.println(solution.isPossibleToCreateTheSameStringWithinOneEdit("pale", "bale"));
        System.out.println(solution.isPossibleToCreateTheSameStringWithinOneEdit("pale", "bake"));
    }

    public boolean isPossibleToCreateTheSameStringWithinOneEdit(String str1, String str2) {
        int diff = Math.abs(str1.length() - str2.length());
        if (diff == 0) {
            return isPossibleToCreateTheSameStringOneReplace(str1, str2);
        }
        if (diff == 1) {
            return str1.length() > str2.length() ?
                    isPossibleToCreateTheSameStringOneAdd(str2, str1) : isPossibleToCreateTheSameStringOneAdd(str1, str2);
        }
        return false;
    }

    private boolean isPossibleToCreateTheSameStringOneReplace(String str1, String str2) {
        if (str1.length() != str2.length()) {
            throw new RuntimeException("invalid input.");
        }

        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count <= 1;
    }

    private boolean isPossibleToCreateTheSameStringOneAdd(String str1, String str2) {
        if (str1.length() >= str2.length()) {
            throw new RuntimeException("invalid input.");
        }

        int index1 = 0, index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }
}
