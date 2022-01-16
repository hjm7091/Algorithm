package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_4;

public class BookSolution2 {

    public static void main(String[] args) {
        BookSolution2 bookSolution = new BookSolution2();
        boolean result1 = bookSolution.isPermutationOfPalindrome("Tact Coa");
        boolean result2 = bookSolution.isPermutationOfPalindrome("TactKCoa");
        System.out.println(result1);
        System.out.println(result2);
    }

    public boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
