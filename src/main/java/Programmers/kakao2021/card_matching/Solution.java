package Programmers.kakao2021.card_matching;

import java.util.*;

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Solution {

    private final int BOARD_SIZE = 4;
    private final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    private final Map<Integer, List<Position>> numbersMap = new HashMap<>();

    int minCost = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {

        for (List<Integer> numbers : makePermutations(board)) {
            Position start = new Position(r, c);
            calCost(0, start, null, 0, numbers, deepCopy(board));
        }

        return minCost;
    }

    private int[][] deepCopy(int[][] board) {
        int[][] copy = new int[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0; x < BOARD_SIZE; x++) {
            System.arraycopy(board[x], 0, copy[x], 0, BOARD_SIZE);
        }
        return copy;
    }

    private void calCost(int cost, Position now, Position other, int idx, List<Integer> numbers, int[][] board) {

        if (isAllCleaned(board)) {
            minCost = Integer.min(minCost, cost);
            return;
        }

        Integer targetNumber = numbers.get(idx);
        int[][] distances = calMinDistanceFromNow(now, board);

        if (other != null) {
            board[other.x][other.y] = 0;
            int costOther = distances[other.x][other.y];
            calCost(cost + costOther + 1, other, null, idx + 1, numbers, board);
            board[other.x][other.y] = targetNumber;
            return;
        }

        List<Position> positions = numbersMap.get(targetNumber);
        Position A = positions.get(0), B = positions.get(1);
        int costA = distances[A.x][A.y], costB = distances[B.x][B.y];

        // A 선택
        board[A.x][A.y] = 0;
        calCost(cost + costA + 1, A, B, idx, numbers, board);
        board[A.x][A.y] = targetNumber;

        // B 선택
        board[B.x][B.y] = 0;
        calCost(cost + costB + 1, B, A, idx, numbers, board);
        board[B.x][B.y] = targetNumber;
    }

    private boolean isAllCleaned(int[][] board) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] != 0)
                    return false;
            }
        }
        return true;
    }

    private int[][] calMinDistanceFromNow(Position now, int[][] board) {

        int[][] distances = new int[BOARD_SIZE][BOARD_SIZE];
        boolean[][] visit = new boolean[BOARD_SIZE][BOARD_SIZE];
        Queue<Position> queue = new LinkedList<>();
        queue.add(now);
        visit[now.x][now.y] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int dir = 0; dir < 4; dir++) {

                Position next = new Position(current.x + dx[dir], current.y + dy[dir]);

                if (!outOfRange(next) && !visit[next.x][next.y]) {
                    distances[next.x][next.y] = distances[current.x][current.y] + 1;
                    visit[next.x][next.y] = true;
                    queue.add(next);
                }

                if (!outOfRange(next)) {
                    Position ctrlPos = calCtrlPosition(next, dir, board);
                    if (!visit[ctrlPos.x][ctrlPos.y]) {
                        distances[ctrlPos.x][ctrlPos.y] = distances[current.x][current.y] + 1;
                        visit[ctrlPos.x][ctrlPos.y] = true;
                        queue.add(ctrlPos);
                    }
                }
            }
        }

        return distances;
    }

    private Position calCtrlPosition(Position position, int dir, int[][] board) {
        Position next = new Position(position.x, position.y);
        while (true) {
            if (board[next.x][next.y] != 0) {
                break;
            }

            next.x += dx[dir];
            next.y += dy[dir];

            if (outOfRange(next)) {
                next.x -= dx[dir];
                next.y -= dy[dir];
                break;
            }
        }
        return next;
    }

    private boolean outOfRange(Position pos) {
        return pos.x < 0 || pos.x >= BOARD_SIZE || pos.y < 0 || pos.y >= BOARD_SIZE;
    }

    private List<List<Integer>> makePermutations(int[][] board) {

        Set<Integer> numbers = new HashSet<>();

        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] == 0) continue;
                numbers.add(board[x][y]);
                List<Position> positions = numbersMap.getOrDefault(board[x][y], new ArrayList<>());
                positions.add(new Position(x, y));
                numbersMap.put(board[x][y], positions);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        chooseNumbers(new boolean[numbers.size()], new ArrayList<>(), new ArrayList<>(numbers), result);

        return result;
    }

    private void chooseNumbers(boolean[] isChosen, List<Integer> chosenNumbers, List<Integer> numbers, List<List<Integer>> result) {
        if (chosenNumbers.size() == numbers.size()) {
            result.add(new ArrayList<>(chosenNumbers));
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!isChosen[i]) {
                isChosen[i] = true;
                chosenNumbers.add(numbers.get(i));
                chooseNumbers(isChosen, chosenNumbers, numbers, result);
                chosenNumbers.remove(chosenNumbers.size() - 1);
                isChosen[i] = false;
            }
        }
    }

}
