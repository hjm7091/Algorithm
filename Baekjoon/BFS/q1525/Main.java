package q1525;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {-1, 1, 0, 0};
	static final int target = 123456789;
	static final int N = 3;
	static int start;
	
	public static void main(String[] args) {
		input();
		System.out.println(bfs());
	}
	
	private static void input() {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = input.nextInt();
				if(num == 0)
					num = 9;
				start = start * 10 + num;
			}
		}
		input.close();
	}
	
	private static int bfs() {
		int result = -1;
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> d = new HashMap<>();
		d.put(start, 0);
		q.add(start);
		while(!q.isEmpty()) {
			int nowNum = q.poll();
			String now = Integer.toString(nowNum);
			int pos = now.indexOf('9');
			int x = pos / N;
			int y = pos % N;
			for(int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(!rangeOver(nx, ny)) {
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(x * N + y);
					next.setCharAt(x * N + y, next.charAt(nx * N + ny));
					next.setCharAt(nx * N + ny, temp);
					int nextNum = Integer.parseInt(next.toString());
					if(!d.containsKey(nextNum)) {
						d.put(nextNum, d.get(nowNum) + 1);
						q.add(nextNum);
					}
				}
			}
		}
		if(d.containsKey(target))
			result = d.get(target);
		return result;
	}
	
	private static boolean rangeOver(int x, int y) {
		if(x < 0 || x > N-1 || y < 0 || y > N-1)
			return true;
		return false;
	}

}
