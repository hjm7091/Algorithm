package practice;
import java.util.Scanner;

public class BoardCover {

	static Scanner input;
	static int C,H,W; //C:�׽�Ʈ ���̽� ��, H:����, W:����
	static int[][] board; //1�� ����ĭ, 0�� ��ĭ
	static int[] result; //����� ������ �迭
	static int[][][] coverType = { //3���� �迭�� ����Ͽ� �־��� ĭ�� ���� �� �ִ� �װ��� ����� ����, ������ ���� ������ ���� ��, �� ���� Ÿ�Դ� 3���� ���� ä���.
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
	
	public static boolean set(int x, int y, int type, int delta) { //board�� (x,y)�� type�� ������� ���ų�, ������ ����� ����
		boolean ok = true;										   //delta=1�̸� ���� delta=-1�̸� ����
		int nx=0, ny=0;
		for(int i=0; i<3; i++) {
			nx = x + coverType[type][i][0];
			ny = y + coverType[type][i][1];
		if(nx<0||nx>=H||ny<0||ny>=W) //����� �������� ����� false
			ok = false;
		else if((board[nx][ny] += delta) > 1) //����� �������� ������ false, board[x][y] > 1 �̸� ������ ���� �� ���ļ� ���� ���� �ǹ�
			ok = false;						  //������ �� : ok�� false��� �ٷ� �����ϸ� �ȵ� �ֳ��ϸ� ������ type�� ���߿� ���� ���̱� �����̴�.
		}
		return ok;
	}
	
	public static int cover() {        //board�� ��� �� ĭ�� ���� �� �ִ� ����� ���� ��ȯ
		int x=-1, y=-1;				   
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(board[i][j]==0) {   //1�� �̹� ���� ĭ�̰ų� ���� ĭ, 0�� ���� ������ ���� ĭ
					x = i;
					y = j;
					break;
				}
			}
			if(y!=-1)	//���� for���� ����� ���� ����
				break;
		}
		if(y==-1) //���� ���:��� ĭ�� ä������ ĭ�� ä��� �Ѱ��� ����� ���� �ش��ϹǷ� 1�� ��ȯ
			return 1;
		int ret = 0;
		for(int type=0; type<4; type++) {
			if(set(x,y,type,1)) //���� board�� type�� ���·� ���� �� ������ ���ȣ���� 
				ret += cover();
			set(x,y,type,-1); //������ type�� ����
		}
		return ret;
	}
}
