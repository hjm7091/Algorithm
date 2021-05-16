package Programmers.kakao2020.move_block;

import java.util.*;

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "x:" + x + " y:" + y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Location))
			return false;
		Location loc = (Location) obj;
		if(loc.x == this.x && loc.y == this.y)
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.toString(x).hashCode() + Integer.toString(y).hashCode();
	}
	
}

class Robot {
	Location loc1, loc2;
	int time;
	public Robot(Location loc1, Location loc2, int time) {
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.time = time;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Robot))
			return false;
		Robot robot = (Robot) obj;
		if(robot.loc1.equals(loc1) && robot.loc2.equals(loc2))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return loc1.hashCode() + loc2.hashCode();
	}
}

public class Solution {
	
	int[][] board;
	int N;
	Location destination;
	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};
	Set<Robot> visit = new HashSet<>();
	
	public int solution(int[][] board) {
        init(board);
		int answer = performBfs();
        return answer;
    }
	
	private void init(int[][] board) {
		this.board = board;
		N = board.length;
		destination = new Location(N-1, N-1);
	}
	
	private int performBfs() {
		int result = -1;
		Queue<Robot> q = new LinkedList<>();
		q.add(new Robot(new Location(0, 0), new Location(0, 1), 0));
		while(!q.isEmpty()) {
			Robot now = q.poll();
			if(now.loc1.equals(destination) || now.loc2.equals(destination)) {
				result = now.time;
				break;
			}
			q.addAll(getPossibleRobot(now.loc1, now.loc2, now.time));
			q.addAll(getPossibleRobot(now.loc2, now.loc1, now.time));
			for(int dir = 0; dir < 4; dir++) {
				Location nextLoc1 = new Location(now.loc1.x + dx[dir], now.loc1.y + dy[dir]);
				Location nextLoc2 = new Location(now.loc2.x + dx[dir], now.loc2.y + dy[dir]);
				if(rangeOver(nextLoc1) || rangeOver(nextLoc2))
					continue;
				if(isBlock(nextLoc1) || isBlock(nextLoc2))
					continue;
				Robot next = new Robot(nextLoc1, nextLoc2, now.time+1);
				if(visit.contains(next))
					continue;
				q.add(next);
				visit.add(next);
			}
		}
		return result;
	}
	
	private List<Robot> getPossibleRobot(Location pivot, Location comp, int time){
		List<Robot> next = new ArrayList<>();
		String pos = compare(pivot, comp);
		if(pos.equals("up") || pos.equals("down")) {
			//�Ǻ��� �������� �������� ȸ�� 
			Location left_from_comp = new Location(comp.x, comp.y-1);
			Location left_from_pivot = new Location(pivot.x, pivot.y-1);
			if(canRotate(left_from_comp, left_from_pivot)) {
				Robot nextRobot = new Robot(left_from_pivot, pivot, time+1);
				if(!visit.contains(nextRobot)) {
					next.add(nextRobot);
					visit.add(nextRobot);
				}
			}
			
			//�Ǻ��� �������� ���������� ȸ��
			Location right_from_comp = new Location(comp.x, comp.y+1);
			Location right_from_pivot = new Location(pivot.x, pivot.y+1);
			if(canRotate(right_from_comp, right_from_pivot)) {
				Robot nextRobot = new Robot(right_from_pivot, pivot, time+1);
				if(!visit.contains(nextRobot)) {
					next.add(nextRobot);
					visit.add(nextRobot);
				}
			}
		}
		else if(pos.equals("left") || pos.equals("right")) {
			//�Ǻ��� �������� �������� ȸ��
			Location up_from_comp = new Location(comp.x-1, comp.y);
			Location up_from_pivot = new Location(pivot.x-1, pivot.y);
			if(canRotate(up_from_comp, up_from_pivot)) {
				Robot nextRobot = new Robot(up_from_pivot, pivot, time+1);
				if(!visit.contains(nextRobot)) {
					next.add(nextRobot);
					visit.add(nextRobot);
				}
			}
			
			//�Ǻ��� �������� �Ʒ������� ȸ��
			Location down_from_comp = new Location(comp.x+1, comp.y);
			Location down_from_pivot = new Location(pivot.x+1, pivot.y);
			if(canRotate(down_from_comp, down_from_pivot)) {
				Robot nextRobot = new Robot(down_from_pivot, pivot, time+1);
				if(!visit.contains(nextRobot)) {
					next.add(nextRobot);
					visit.add(nextRobot);
				}
			}
		}
		return next;
	}
	
	private String compare(Location p, Location loc) {
		if(loc.x == p.x) {
			if(loc.y < p.y) {
				return "left";
			}
			else if(loc.y > p.y) {
				return "right";
			}
		} else if(loc.x < p.x) {
			return "up";
		} else if(loc.x > p.x) {
			return "down";
		}
		return "impossible";
	}
	
	private boolean canRotate(Location pass, Location des) {
		if(rangeOver(pass) || rangeOver(des))
			return false;
		if(isBlock(pass) || isBlock(des))
			return false;
		return true;
	}
	
	private boolean isBlock(Location loc) {
		if(board[loc.x][loc.y] == 1)
			return true;
		return false;
	}
	
	private boolean rangeOver(Location loc) {
		if(loc.x < 0 || loc.x > N-1 || loc.y < 0 || loc.y > N-1)
			return true;
		return false;
	}
}
