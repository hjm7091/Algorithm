package programmers.kakao2020.posts_and_beams;

import java.util.Set;
import java.util.TreeSet;

class Struct implements Comparable<Struct> {
	int x, y, kind;
	public Struct(int x, int y, int kind) {
		this.x = x;
		this.y = y;
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		return "x:" + x + " y:" + y + " kind:" + kind;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Struct)) 
			return false;
		Struct s = (Struct) obj;
		if(s.x == x && s.y == y && s.kind == kind)
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.toString(x).hashCode() + Integer.toString(y).hashCode() + Integer.toString(kind).hashCode();
	}

	@Override
	public int compareTo(Struct s) {
		if(this.x == s.x) {
			if(this.y == s.y) {
				return this.kind - s.kind;
			}
			return this.y - s.y;
		}
		return this.x - s.x;
	}
}

public class Solution {

	final int POST = 0, BEAM = 1; //POST:기둥, BEAM:보
	final int PUT = 1, REMOVE = 0; 
	Set<Struct> structs = new TreeSet<>();
	
	public int[][] solution(int n, int[][] build_frame) {
        simulation(n, build_frame);
		int[][] answer = makeArray();
        return answer;
    }
	
	private void simulation(int n, int[][] build_frame) {
		for(int[] info : build_frame) {
			int x = info[0];
			int y = info[1];
			int a = info[2];
			int b = info[3];
			Struct struct = new Struct(x, y, a);
			if(b == PUT) {
				structs.add(struct);
				if(!check())
					structs.remove(struct);
			}
			else if(b == REMOVE){
				structs.remove(struct);
				if(!check())
					structs.add(struct);
			}
		}
	}
	
	private boolean check() {
		for(Struct struct : structs) {
			if(struct.kind == POST) {
				Struct upPost = new Struct(struct.x, struct.y-1, POST); //현재 기둥 위쪽의 기둥
				Struct leftBeam = new Struct(struct.x-1, struct.y, BEAM); //현재 기둥 왼쪽의 보
				Struct rightBeam = new Struct(struct.x, struct.y, BEAM); //현재 기둥 오른쪽의 보
				if(struct.y == 0 || structs.contains(upPost) || structs.contains(leftBeam) || structs.contains(rightBeam))
					continue;
				else
					return false;
			}
			else if(struct.kind == BEAM) {
				Struct leftPost = new Struct(struct.x, struct.y-1, POST); //현재 보 왼쪽의 기둥
				Struct rightPost = new Struct(struct.x+1, struct.y-1, POST); //현재 보 오른쪽의 기둥
				Struct leftBeam = new Struct(struct.x-1, struct.y, BEAM); //현재 보 왼쪽의 보
				Struct rightBeam = new Struct(struct.x+1, struct.y, BEAM); //현재 보 오른쪽의 보
				if(structs.contains(leftPost) || structs.contains(rightPost) || (structs.contains(leftBeam) && structs.contains(rightBeam)))
					continue;
				else
					return false;
			}
		}
		return true;
	}
	
	private int[][] makeArray() {
		int[][] answer = new int[structs.size()][3];
		int i = 0;
		for(Struct struct : structs) {
			answer[i][0] = struct.x;
			answer[i][1] = struct.y;
			answer[i][2] = struct.kind;
			i++;
		}
		return answer;
	}
	
}
