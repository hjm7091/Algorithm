package baekjoon.brute_force.q16197;
import java.util.Scanner;

class Coin {
	int x, y;
	public Coin(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M;
	static char[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dir = new int[10];
	static int result = Integer.MAX_VALUE;
	static Coin coin1 = null, coin2 = null;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		board = new char[N][M];
		for(int x=0; x<N; x++) {
			board[x] = input.next().toCharArray();
			for(int y=0; y<M; y++) {
				if(board[x][y]=='o') {
					if(coin1 == null)
						coin1 = new Coin(x, y);
					else
						coin2 = new Coin(x, y);
				}
			}
		}
		makeDirection(0);
		if(result==Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);
		input.close();
	}
	
	public static void makeDirection(int index) {
		if(index>=10) {
			int num = 0;
			Coin copy1 = new Coin(coin1.x, coin1.y);
			Coin copy2 = new Coin(coin2.x, coin2.y);
			for(int d : dir) {
				copy1 = moveCoin(d, copy1);
				copy2 = moveCoin(d, copy2);
				num++;
				if(overBoth(copy1, copy2)) 
					return;
				if(overOne(copy1, copy2)) {
					result = Integer.min(result, num);
					return;
				}
			}
			return;
		}
		for(int i=0; i<4; i++) {
			dir[index] = i;
			makeDirection(index+1);
		}
	}
	
	public static boolean overBoth(Coin coin1, Coin coin2) {
		if(coin1==null && coin2==null)
			return true;
		return false;
	}
	
	public static boolean overOne(Coin coin1, Coin coin2) {
		if((coin1==null && coin2!=null) || (coin1!=null && coin2==null))
			return true;
		return false;
	}
	
	public static Coin moveCoin(int d, Coin coin) {
		int nx = coin.x + dx[d];
		int ny = coin.y + dy[d];
		if(checkRange(nx, ny)) {
			return null;
		}
		if(board[nx][ny]=='#')
			return coin;
		return new Coin(nx, ny);
	}
	
	public static boolean checkRange(int x, int y) {
		if(x<0 || x>N-1 || y<0 || y>M-1)
			return true;
		return false;
	}

}
