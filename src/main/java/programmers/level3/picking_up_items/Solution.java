package programmers.level3.picking_up_items;

class Point {
	final int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Point o) {
		return this.x == o.x && this.y == o.y;
	}
}

public class Solution {

	int result = Integer.MAX_VALUE;
	int[] dx = {1, 0, -1, 0};
	int[] dy = {0, 1, 0, -1};

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] board = initBoardFrom(rectangle);
		Point character = new Point(characterX * 2, characterY * 2);
		Point item = new Point(itemX * 2, itemY * 2);
		dfs(character, item, new boolean[102][102], board, 0);
		return result / 2;
	}

	private void dfs(Point curr, Point item, boolean[][] visit, int[][] board, int dis) {
		visit[curr.x][curr.y] = true;
		if (curr.equals(item)) {
			result = Math.min(result, dis);
		} else {
			for (int dir = 0; dir < 4; dir++) {
				int nx = curr.x + dx[dir], ny = curr.y + dy[dir];
				if (visit[nx][ny] || board[nx][ny] != 1) continue;
				dfs(new Point(nx, ny), item, visit, board, dis + 1);
			}
		}
		visit[curr.x][curr.y] = false;
	}

	private int[][] initBoardFrom(int[][] rectangle) {
		int[][] board = new int[102][102];

		for (int[] rect : rectangle) {
			for (int i = 0; i < rect.length; i++) rect[i] *= 2;

			for (int x = rect[0]; x <= rect[2]; x++) {
				for (int y = rect[1]; y <= rect[3]; y++) {
					if ((x == rect[0] || x == rect[2] || y == rect[1] || y == rect[3]) && (board[x][y] != 2))
						board[x][y] = 1;
					else
						board[x][y] = 2;
				}
			}
		}

		return board;
	}

}
