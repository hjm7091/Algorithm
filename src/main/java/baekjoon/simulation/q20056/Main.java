package baekjoon.simulation.q20056;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FireBall {
	int mass, speed, direction;
	public FireBall(int mass, int speed, int direction) {
		this.mass = mass;
		this.speed = speed;
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "(m:" + mass + ", s:" + speed + ", d:" + direction + ")";
	}
}

public class Main {

	int N, M, K;
	List<FireBall>[][] map, temp;
	int[] dx = {-1,-1,0,1,1,1,0,-1};
	int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solve();
	}

	private void solve() {
		init();
		while(K-- > 0) {
			step1(this.map);
			step2(this.map);
		}
		
		System.out.println(calMassSum(this.map));
	}

	private void step1(List<FireBall>[][] map) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c].size() > 0) {
					for(FireBall ball : map[r][c]) {
						int distance = ball.speed % N;
						int nr = r + dx[ball.direction] * distance;
						int nc = c + dy[ball.direction] * distance;
						nr = nr >= N ? nr - N : nr; 
						nr = nr < 0 ? nr + N : nr;
						nc = nc >= N ? nc - N : nc;
						nc = nc < 0 ? nc + N : nc;
						
						this.temp[nr][nc].add(new FireBall(ball.mass, ball.speed, ball.direction));
					}
				}
			}
		}
		
		copy(this.map, this.temp);
		clear(this.temp);
	}
	
	private void step2(List<FireBall>[][] map) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c].size() >= 2) {
					int nMass = 0, nSpeed = 0;
					for(FireBall ball : map[r][c]) {
						nMass += ball.mass;
						nSpeed += ball.speed;
					}
					
					nMass /= 5;
					nSpeed /= map[r][c].size();
					
					if(nMass == 0) {
						map[r][c].clear();
						continue;
					}
					
					List<FireBall> split = new ArrayList<FireBall>();
					
					if(isAllOdd(map[r][c]) || isAllEven(map[r][c])) {
						for(int dir = 0; dir <= 6; dir += 2) {
							split.add(new FireBall(nMass, nSpeed, dir));
						}
					} else {
						for(int dir = 1; dir <= 7; dir += 2) {
							split.add(new FireBall(nMass, nSpeed, dir));
						}
					}
					
					map[r][c].clear();
					map[r][c].addAll(split);
				}
			}
		}
	}
	
	private boolean isAllOdd(List<FireBall> balls) {
		for(FireBall ball : balls) {
			if(ball.direction % 2 != 1)
				return false;
		}
		return true;
	}
	
	private boolean isAllEven(List<FireBall> balls) {
		for(FireBall ball : balls) {
			if(ball.direction % 2 != 0)
				return false;
		}
		return true;
	}
	
	private int calMassSum(List<FireBall>[][] map) {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() > 0) {
					for(FireBall ball : map[i][j]) {
						sum += ball.mass;
					}
				}
			}
		}
		return sum;
	}
	
	private void clear(List<FireBall>[][] map) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() > 0) {
					map[i][j].clear();
				}
			}
		}	
	}
	
	private void copy(List<FireBall>[][] to, List<FireBall>[][] from) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				to[i][j].clear();
				to[i][j].addAll(from[i][j]);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt(); M = input.nextInt(); K = input.nextInt();
		
		map = new ArrayList[N][N];
		temp = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<FireBall>();
				temp[i][j] = new ArrayList<FireBall>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			int r = input.nextInt() - 1; int c = input.nextInt() - 1;
			int m = input.nextInt(); int s = input.nextInt(); int d = input.nextInt();
			map[r][c].add(new FireBall(m, s, d));
		}
		
		input.close();
	}

}
