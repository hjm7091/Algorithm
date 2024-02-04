package study.cracking_the_coding_interview_6e.array_string.problem1_4;

public class BookSolution1 {

    public static void main(String[] args) {
        BookSolution1 bookSolution = new BookSolution1();
        boolean result1 = bookSolution.isPermutationOfPalindrome("Tact Coa");
        boolean result2 = bookSolution.isPermutationOfPalindrome("TactKCoa");
        System.out.println(result1);
        System.out.println(result2);
    }

    public boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
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

    private int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }
}
