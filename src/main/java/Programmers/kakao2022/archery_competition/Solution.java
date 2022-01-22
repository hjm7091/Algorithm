package Programmers.kakao2022.archery_competition;

import java.util.Arrays;

public class Solution {

    private final int MAX_NUM = 11;
    private int[] maxScores = null;
    private int maxDiff = -1;

    public int[] solution(int n, int[] info) {

        shootMoreArrowsOrNothing(0, n, new int[MAX_NUM], info);

        return maxScores == null ? new int[] {-1} : maxScores;
    }

    private void shootMoreArrowsOrNothing(int index, int arrowCount, int[] lionScores, int[] apeachScores) {
        if (index == MAX_NUM || arrowCount == 0) {
            lionScores[MAX_NUM - 1] = arrowCount;
            int scoreDiff = calculateScoreDiff(lionScores, apeachScores);
            if (scoreDiff != -1) {
                if (scoreDiff > maxDiff) {
                    maxDiff = scoreDiff;
                    maxScores = Arrays.copyOf(lionScores, MAX_NUM);
                } else if (scoreDiff == maxDiff) {
                   if (isBetter(lionScores)) {
                       maxScores = Arrays.copyOf(lionScores, MAX_NUM);
                   }
                }
            }
            lionScores[MAX_NUM - 1] = 0;
            return;
        }

        if (apeachScores[index] < arrowCount) {
            lionScores[index] = apeachScores[index] + 1;
            shootMoreArrowsOrNothing(index + 1, arrowCount - apeachScores[index] - 1, lionScores, apeachScores);
            lionScores[index] = 0;
        }

        shootMoreArrowsOrNothing(index + 1, arrowCount, lionScores, apeachScores);
    }

    private boolean isBetter(int[] lionScores) {
        for (int i = MAX_NUM - 1; i >= 0; i--) {
            if (lionScores[i] > maxScores[i]) return true;
            else if (lionScores[i] < maxScores[i]) return false;
        }
        return false;
    }

    private int calculateScoreDiff(int[] lionScores, int[] apeachScores) {
        int lionScore = 0, apeachScore = 0;
        for (int i = 0, score = 10; i < MAX_NUM; i++, score--) {
            if (lionScores[i] == 0 && apeachScores[i] == 0) continue;

            if (apeachScores[i] >= lionScores[i]) {
                apeachScore += score;
            } else {
                lionScore += score;
            }
        }

        return lionScore > apeachScore ? lionScore - apeachScore : -1;
    }

}
