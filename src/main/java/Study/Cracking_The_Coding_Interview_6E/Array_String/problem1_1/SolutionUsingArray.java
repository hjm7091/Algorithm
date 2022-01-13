package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_1;

public class SolutionUsingArray {

    public static void main(String[] args) {
        SolutionUsingArray solutionUsingArray = new SolutionUsingArray();
        System.out.println(solutionUsingArray.isUniqueChars("abcdefg"));
        System.out.println(solutionUsingArray.isUniqueChars("abcdeda"));
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
