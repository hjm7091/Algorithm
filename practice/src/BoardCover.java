import java.util.Scanner;

public class BoardCover {

	static Scanner input;
	static int C,H,W; //C:테스트 케이스 수, H:세로, W:가로
	static int[][] board; //1은 검은칸, 0은 흰칸
	static int[] result; //결과를 저장할 배열
	static int[][][] coverType = { //3차원 배열을 사용하여 주어진 칸을 덮을 수 있는 네가지 방법을 만들어냄, 기준은 가장 왼쪽의 가장 위, 한 개의 타입당 3개의 점을 채운다.
			{{0,0},{0,1},{1,0}}, //type 0
			{{0,0},{0,1},{1,1}}, //type 1
			{{0,0},{1,0},{1,1}}, //type 2
			{{0,0},{1,0},{1,-1}} //type 3
	};
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		C = input.nextInt();
		result = new int[C];
		for(int i=0; i<C; i++) {
			H = input.nextInt();
			W = input.nextInt();
			board = new int[H][W];
			init();
			result[i] = cover();
		}
		for(int i=0; i<C; i++)
			System.out.println(result[i]);
		System.out.println();
	}
	
	public static void init() {
		for(int x=0; x<H; x++)
			for(int y=0; y<W; y++)
				board[x][y] = input.nextInt();
	}
	
	public static boolean set(int x, int y, int type, int delta) { //board의 (x,y)를 type번 방법으로 덮거나, 덮었던 블록을 없앰
		boolean ok = true;										   //delta=1이면 덮고 delta=-1이면 없앰
		int nx=0, ny=0;
		for(int i=0; i<3; i++) {
			nx = x + coverType[type][i][0];
			ny = y + coverType[type][i][1];
		if(nx<0||nx>=H||ny<0||ny>=W) //블록이 게임판을 벗어나면 false
			ok = false;
		else if((board[nx][ny] += delta) > 1) //블록이 검은판을 덮으면 false, board[x][y] > 1 이면 검은판 위에 또 겹쳐서 덮은 것을 의미
			ok = false;						  //유의할 점 : ok가 false라고 바로 종료하면 안됨 왜냐하면 덮었던 type을 나중에 없앨 것이기 때문이다.
		}
		return ok;
	}
	
	public static int cover() {        //board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환
		int x=-1, y=-1;				   
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(board[i][j]==0) {   //1은 이미 덮인 칸이거나 검은 칸, 0은 아직 덮이지 않은 칸
					x = i;
					y = j;
					break;
				}
			}
			if(y!=-1)	//이중 for문을 벗어나기 위한 조건
				break;
		}
		if(y==-1) //기저 사례:모든 칸을 채웠으면 칸을 채우는 한가지 경우의 수에 해당하므로 1을 반환
			return 1;
		int ret = 0;
		for(int type=0; type<4; type++) {
			if(set(x,y,type,1)) //만약 board를 type의 형태로 덮을 수 있으면 재귀호출함 
				ret += cover();
			set(x,y,type,-1); //덮었던 type을 없앰
		}
		return ret;
	}

}
