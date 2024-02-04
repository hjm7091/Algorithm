package programmers.dev_matching2021.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<Integer, Integer> ranks = new HashMap<>();

    static {
        ranks.put(6, 1);
        ranks.put(5, 2);
        ranks.put(4, 3);
        ranks.put(3, 4);
        ranks.put(2, 5);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        return findPossibleMaxAndMinRank(lottos, win_nums);
    }

    private int[] findPossibleMaxAndMinRank(int[] lottos, int[] wins_nums) {
        int match = 0;
        int zero = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }

            if (isMatched(lotto, wins_nums)) {
                match++;
            }
        }

        return new int[]{ranks.getOrDefault(match + zero, 6), ranks.getOrDefault(match, 6)};
    }

    private boolean isMatched(int lotto, int[] wins_nums) {
        for (int num : wins_nums) {
            if (lotto == num)
                return true;
        }
        return false;
    }

}
