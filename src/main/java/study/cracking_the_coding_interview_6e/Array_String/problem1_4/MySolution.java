package study.cracking_the_coding_interview_6e.array_string.problem1_4;

public class MySolution {

    public static void main(String[] args) {
        MySolution mySolution = new MySolution();
        boolean result1 = mySolution.isPalindromicPermutation("Tact Coa");
        boolean result2 = mySolution.isPalindromicPermutation("TactKCoa");
        System.out.println(result1);
        System.out.println(result2);
    }

    public boolean isPalindromicPermutation(String s) {
        s = s.toLowerCase();
        int[] letters = new int[128];

        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            letters[c]++;
        }

        int invalidCount = 0;
        for (int count : letters) {
            if (count % 2 != 0) {
                invalidCount++;
            }
        }

        return invalidCount <= 1;
    }
}
