package Baekjoon.Simulation.q8982;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Point {
	
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

class Line {
	
	Point p1, p2;
	int depth; 
	int drained; //빠진 물의 양
	int idx; //몇번째 라인인지 저장
	
	public Line(Point p1, Point p2, int depth, int drained, int idx) {
		this.p1 = p1;
		this.p2 = p2;
		this.depth = depth;
		this.drained = drained;
		this.idx = idx;
	}
	
	@Override
	public String toString() {
		return p1.toString() + "->" + p2.toString() + " depth:" + depth + " drained:" + drained + " idx:" + idx;
	}
}

public class Main {
	
	static int N, K;
	static List<Line> horizontal = new ArrayList<>();
	static List<Line> holes = new ArrayList<>();
	static int maxX;
	
	public static void main(String[] args) {
		init();
		drainedWater();
		System.out.println(calTotalWater());
	}
	
	private static void init() {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		int x = input.nextInt();
		int y = input.nextInt();
		Point prev = new Point(x, y);
		int idx = 0;
		for(int i = 1; i < N-1; i++) {
			x = input.nextInt();
			y = input.nextInt();
			Point now = new Point(x, y);
			if(prev.y == now.y)
				horizontal.add(new Line(prev, now, prev.y, 0, idx++));
			prev = now;
		}
		x = input.nextInt();
		y = input.nextInt();
		maxX = idx;
		
		K = input.nextInt();
		input.nextLine();
		for(int i = 0; i < K; i++) {
			String[] info = input.nextLine().split(" ");
			int a = Integer.parseInt(info[0]);
			int b = Integer.parseInt(info[1]);
			int c = Integer.parseInt(info[2]);
			for(Line line : horizontal) {
				Point left = line.p1;
				Point right = line.p2;
				if(left.x == a && right.x == c && 
						left.y == b && right.y == b)
					holes.add(line);
			}
		}
		
		Collections.sort(holes, new Comparator<Line>() {
			@Override
			public int compare(Line l1, Line l2) {
				return l1.p1.y - l2.p1.y;
			}
		});
		
		input.close();
	}
	
	private static void drainedWater() {
		for(Line hole : holes) {
			int height = hole.depth;
			int drained = (hole.p2.x - hole.p1.x) * height;
			hole.drained = drained;
			
			//왼쪽
			for(int i = hole.idx - 1; i >=0; i--) {
				Line line = horizontal.get(i);
				height = Integer.min(height, line.depth);
				drained = (line.p2.x - line.p1.x) * height;
				line.drained = Integer.max(line.drained, drained);
			}
			
			height = hole.depth;
			
			//오른쪽
			for(int i = hole.idx + 1; i < maxX; i++) {
				Line line = horizontal.get(i);
				height = Integer.min(height, line.depth);
				drained = (line.p2.x - line.p1.x) * height;
				line.drained = Integer.max(line.drained, drained);
			}
		}
	}
	
	private static int calTotalWater() {
		int result = 0;
		for(Line line : horizontal) {
			int before = (line.p2.x - line.p1.x) * line.depth;
			result += (before - line.drained);
		}
		return result;
	}
	
}
