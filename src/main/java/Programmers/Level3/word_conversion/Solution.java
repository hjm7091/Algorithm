package Programmers.Level3.word_conversion;

public class Solution {

	private boolean[] visit;
	private String target;
	private String[] words;
	private int answer = Integer.MAX_VALUE;
	
	public int solution(String begin, String target, String[] words) {
		init(target, words);
        performDfs(begin, 0);
        if(answer == Integer.MAX_VALUE)
        	return 0;
        else
        	return answer;
    }
	
	private void init(String target, String[] words) {
		visit = new boolean[words.length];
		this.target = target;
		this.words = words;
	}
	
	private void performDfs(String begin, int depth) {
		if(begin.equals(target)) {
			answer = Integer.min(answer, depth);
			return;
		}
		for(int i = 0; i < words.length; i++) {
			if(!visit[i] && canConversion(begin, words[i])) {
				visit[i] = true;
				performDfs(words[i], depth + 1);
				visit[i] = false;
			}
		}
	}
	
	private boolean canConversion(String begin, String next) {
		int differentCount = 0;
		for(int i = 0; i < begin.length(); i++) {
			if(begin.charAt(i) != next.charAt(i))
				differentCount++;		
		}
		if(differentCount > 1)
			return false;
		return true;
	}

}
