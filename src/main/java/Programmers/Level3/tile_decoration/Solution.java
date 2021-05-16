package Programmers.Level3.tile_decoration;

public class Solution {

	long[] d;
	
	public long solution(int N) {
		init(N);
		findAnswer(N);
		return d[N];
	}
	
	public void init(int N) {
		d = new long[N+1];
		d[1] = 4;
		d[2] = 6;
	}
	
	public void findAnswer(int N) {
		for(int i=3; i<=N; i++) {
			d[i] = d[i-1] + d[i-2];
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(80));
	}

}
