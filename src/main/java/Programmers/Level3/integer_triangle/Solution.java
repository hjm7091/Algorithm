package Programmers.Level3.integer_triangle;

import java.util.Arrays;

class Point {
	
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	int[][] triangle;
	int[][] d;
	int N;
	
	public int solution(int[][] triangle) {
		initVariable(triangle);
		findMaxPath();
        int answer = Arrays.stream(d[N-1]).max().getAsInt();
        return answer;
    }
	
	private void initVariable(int[][] triangle) {
		this.triangle = triangle;
		N = triangle.length;
		d = new int[N][N];
	}
	
	private void findMaxPath() {
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < triangle[x].length; y++) {
				Point p1 = new Point(x - 1, y - 1);
				Point p2 = new Point(x - 1, y);
				if(!checkRangeOver(p1) && !checkRangeOver(p2)) {
					d[x][y] += Integer.max(d[p1.x][p1.y], d[p2.x][p2.y]);
					d[x][y] += triangle[x][y];
				}
				else if(checkRangeOver(p1) && !checkRangeOver(p2)) {
					d[x][y] = d[p2.x][p2.y] + triangle[x][y];
				}
				else if(!checkRangeOver(p1) && checkRangeOver(p2)) {
					d[x][y] = d[p1.x][p1.y] + triangle[x][y];
				}
				else {
					d[x][y] = triangle[x][y];
				}
			}
		}
	}
	
	private boolean checkRangeOver(Point p) {
		if(p.x < 0 || p.y < 0)
			return true;
		if(d[p.x][p.y] == 0)
			return true;
		return false;
	}

}
