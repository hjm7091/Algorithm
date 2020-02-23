package q2580;

import java.util.Scanner;

public class Main {

	static final int size = 9;
	static int[][] board = new int[size][size];
	static boolean[][] row = new boolean[size][10]; //row[r][num] : r번째 행에 숫자 num이 있으면 true
	static boolean[][] col = new boolean[size][10]; //col[c][num] : c번째 열에 숫자 num이 있으면 true
	static boolean[][] smallRect = new boolean[size][10]; //smallRect[i][num] : i번째 작은 삼각형에 숫자 num이 있으면 true 
	
	public static void main(String[] args) {
		init();
		start(0);
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				board[r][c] = input.nextInt();
				if(board[r][c] != 0) {
					row[r][board[r][c]] = true;
					col[c][board[r][c]] = true;
					smallRect[getNum(r, c)][board[r][c]] = true;
				}
			}
		}
		input.close();
	}
	
	private static int getNum(int r, int c) {
		return ((r / 3) * 3) + (c / 3);
	}
	
	private static void start(int now) {
		if(now == 81) {
			printBoard();
			System.exit(0);
		}
		int r = now / size;
		int c = now % size;
		if(board[r][c] != 0) {
			start(now+1);
		}
		else {
			for(int num = 1; num <= size; num++) {
				if(!row[r][num] && !col[c][num] && !smallRect[getNum(r, c)][num]) {
					row[r][num] = col[c][num] = smallRect[getNum(r, c)][num] = true;
					board[r][c] = num;
					start(now+1);
					board[r][c] = 0;
					row[r][num] = col[c][num] = smallRect[getNum(r, c)][num] = false;
				}
			}
		}
	}
	
	private static void printBoard() {
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
