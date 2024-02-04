package study.cracking_the_coding_interview_6e.array_string.problem1_7;

public class BookSolution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || matrix.length != matrix[0].length) return;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];

                matrix[layer][i] = matrix[last - offset][layer];

                matrix[last - offset][layer] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }
    }

}
