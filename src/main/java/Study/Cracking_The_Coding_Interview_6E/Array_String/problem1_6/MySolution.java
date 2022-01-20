package Study.Cracking_The_Coding_Interview_6E.Array_String.problem1_6;

public class MySolution {

    public static void main(String[] args) {
        MySolution solution = new MySolution();
        System.out.println(solution.compress("aabccccaaa"));
        System.out.println(solution.compress("aa"));
        System.out.println(solution.compress("ab"));
    }

    public String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        Character prev = null;
        int count = 0;

        for (char curr : str.toCharArray()) {
            if (prev == null) {
                prev = curr;
                count++;
                continue;
            }

            if (prev == curr) {
                count++;
            } else {
                compressed.append(prev).append(count);
                count = 1;
                prev = curr;
            }
        }

        if (prev != null && count > 0) {
            compressed.append(prev).append(count);
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
