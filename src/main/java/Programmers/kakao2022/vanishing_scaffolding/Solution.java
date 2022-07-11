package Programmers.kakao2022.vanishing_scaffolding;

class Position {

    int x, y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int[] locations) {
        return new Position(locations[0], locations[1]);
    }

    public boolean isOver(Board board) {
        return this.x < 0 || this.x > board.X - 1 || this.y < 0 || this.y > board.Y - 1;
    }

    public boolean isLocatedAtSamePosition(Position other) {
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Board {

    final int X, Y;
    final int[][] board;

    final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    Board(int[][] board) {
        this.board = board;
        this.X = board.length;
        this.Y = board[0].length;
    }

    public GameResult playGame(Position a, Position b) {
        if (gameIsEnd(a)) return new GameResult(false, 0);

        if (a.isLocatedAtSamePosition(b)) return new GameResult(true, 1);

        int minCount = Integer.MAX_VALUE, maxCount = 0;
        boolean canWin = false;

        for (int i = 0; i < 4; i++) {
            Position next = Position.of(new int[]{a.x + dx[i], a.y + dy[i]});
            if (next.isOver(this) || board[next.x][next.y] == 0) continue;

            board[a.x][a.y] = 0;
            GameResult gameResult = playGame(b, next);
            board[a.x][a.y] = 1;

            if (!gameResult.canWin) {
                canWin = true;
                minCount = Math.min(minCount, gameResult.count);
            } else if (!canWin) {
                maxCount = Math.max(maxCount, gameResult.count);
            }
        }

        int count = canWin ? minCount : maxCount;
        return new GameResult(canWin, count + 1);
    }

    private boolean gameIsEnd(Position curr) {
        for (int i = 0; i < 4; i++) {
            Position next = Position.of(new int[]{curr.x + dx[i], curr.y + dy[i]});
            if (!next.isOver(this) && board[next.x][next.y] == 1)
                return false;
        }
        return true;
    }

    static class GameResult {
        boolean canWin;
        int count;

        public GameResult(boolean canWin, int count) {
            this.canWin = canWin;
            this.count = count;
        }
    }
}

public class Solution {

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return new Board(board)
                .playGame(Position.of(aloc), Position.of(bloc))
                .count;
    }

}
