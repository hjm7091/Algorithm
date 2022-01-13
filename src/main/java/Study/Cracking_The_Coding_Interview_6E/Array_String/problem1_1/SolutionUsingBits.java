package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_1;

public class SolutionUsingBits {

    public static void main(String[] args) {
        SolutionUsingBits solutionUsingBits = new SolutionUsingBits();
        System.out.println(solutionUsingBits.isUniqueChars("abcdefg"));
        System.out.println(solutionUsingBits.isUniqueChars("abcdeda"));
        System.out.println(solutionUsingBits.isUniqueChars("!)_"));
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
