package baekjoon.simulation.q19236;

import java.util.Scanner;

class Info {
	
	int num, dir;
	public Info(int num, int dir) {
		this.num = num;
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		char[] arrow = { '↑', '↖', '←', '↙', '↓', '↘', '→', '↗' };
		return "(" + num + ", " + arrow[dir] + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		result = prime * result + dir;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Info other = (Info) obj;
		if(num != other.num || dir != other.dir)
			return false;
		return true;
	}
	
}

public class Main {

	private static int[] dx = {-1,-1,0,1,1,1,0,-1};
	private static int[] dy = {0,-1,-1,-1,0,1,1,1};
	private static Info[][] fishes = new Info[4][4];
	private static Info shark = new Info(17, -1);
	private static final Info empty = new Info(-1, -1);
	private static int result = 0;
	
	public static void main(String[] args) {
		init();
		solve();
		System.out.println(result);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int a = input.nextInt();
				int b = input.nextInt();
				fishes[i][j] = new Info(a, b-1);
			}
		}
		input.close();
	}
	
	private static void solve() {
		
		int fishSum = fishes[0][0].num;
		shark.dir = fishes[0][0].dir;
		fishes[0][0] = shark;
		
//		printFishes();
		
		considerAllCase(fishSum, 0, 0);
	
	}
	
	private static void considerAllCase(int fishSum, int x, int y) {
//		System.out.println("\n\n====================new call=====================");

		result = Integer.max(result, fishSum);		
		
		Info[][] tmpFishes = deepCopy(fishes);
		moveFishes();
		
//		System.out.println("=====================after fishes move==========================");
//		printFishes();
		
		int nx = x + dx[shark.dir];
		int ny = y + dy[shark.dir];
		
		while(!rangeOver(nx, ny)) {
			if(fishes[nx][ny].equals(empty)) {
				nx += dx[shark.dir];
				ny += dy[shark.dir];
				continue;
			}
			
			Info tmpNext = fishes[nx][ny];
			Info tmpNow = fishes[x][y];
			int tmpDir = shark.dir;
			
			fishSum += tmpNext.num;
			shark.dir = tmpNext.dir;
			fishes[nx][ny] = shark;
			fishes[x][y] = empty;

//			System.out.println("=====================after shark move==========================");
//			printFishes();
			
			considerAllCase(fishSum, nx, ny);
			
			fishSum -= tmpNext.num;
			shark.dir = tmpDir;
			fishes[nx][ny] = tmpNext;
			fishes[x][y] = tmpNow;
			
//			System.out.println("=====================after shark unmove==========================");
//			printFishes();
			
			nx += dx[shark.dir];
			ny += dy[shark.dir];
		}
		
		fishes = deepCopy(tmpFishes);
		
//		System.out.println("=====================after fishes unmove==========================");
//		printFishes();
		
	}
	
	private static Info[][] deepCopy(Info[][] fishes) {
		Info[][] newFishes = new Info[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				newFishes[i][j] = new Info(fishes[i][j].num, fishes[i][j].dir);
			}
		}
		return newFishes;
	}
	
	private static void moveFishes() {
		for(int n = 1; n <= 16; n++) {
			loop : for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					Info fish = fishes[i][j];
					if(fish.num == n) {
						moveFish(fish, i, j);
//						System.out.println(n);
//						printFishes();
						break loop;
					}
				}
			}
		}
	}
	
	private static void moveFish(Info nowFish, int x, int y) {
		int nx = x + dx[nowFish.dir];
		int ny = y + dy[nowFish.dir];
		
		Info first = new Info(nowFish.num, nowFish.dir);
		
		while(!canMoveToNext(nx, ny)) {
			changeDir(nowFish);
			if(nowFish.equals(first))
				return;
			nx = x + dx[nowFish.dir];
			ny = y + dy[nowFish.dir];
		}
		
		Info tmp = fishes[nx][ny];
		fishes[nx][ny] = nowFish;
		fishes[x][y] = tmp;

	}
	
	private static boolean canMoveToNext(int x, int y) {
		if(x < 0 || x > 3 || y < 0 || y > 3)
			return false;
		if(fishes[x][y].equals(shark))
			return false;
		return true;
	}
	
	private static void changeDir(Info fish) {
		fish.dir += 1;
		if(fish.dir == 8)
			fish.dir = 0;
	}
	
	private static boolean rangeOver(int x, int y) {
		if(x < 0 || x > 3 || y < 0 || y > 3)
			return true;
		return false;
	}
	
	private static void printFishes() {
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(fishes[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
	}

}
