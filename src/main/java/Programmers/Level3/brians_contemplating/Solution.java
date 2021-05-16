package Programmers.Level3.brians_contemplating;

public class Solution {
	
	int[] alpha = new int[26];
	boolean[] visit = new boolean[26];
	boolean exit = false;
	String input = "";
	StringBuilder answer = new StringBuilder();
	
	public String solution(String sentence) {
		input = sentence;
//		System.out.println(input);
		countLowerAlpha();
//		System.out.println(Arrays.toString(alpha));
		findOriginalSentence();
		return answer.toString().trim();
	}
	
	private void countLowerAlpha() {
		for(int idx=0; idx<input.length(); idx++) {
			if(Character.isLowerCase(input.charAt(idx))) {
				alpha[input.charAt(idx) - 'a']++;
			}
		}
	}
	
	private void findOriginalSentence() {
		for(int idx=0; idx<input.length(); idx++) {
			if(exit)
				break;
//			System.out.println(idx);
//			System.out.println(answer.toString());
			char now = input.charAt(idx);
			if(Character.isUpperCase(now)) { //대문자로 시작하는 경우
				if(!checkRangeOver(idx + 1))
					idx = checkNext_prevIsUpper(now, idx + 1);
				else
					answer.append(now);
			}
			else if(Character.isLowerCase(now)) { //소문자로 시작하는 경우
				idx = checkNext_prevIsLower(now, idx + 1);
			}
			else { //대문자나 소문자가 아닌 이외의 경우
				answer = new StringBuilder().append("invalid");
				exit = true;
			}
		}
	}
	
	private boolean checkRangeOver(int idx) {
		if(idx >= input.length())
			return true;
		return false;
	}
	
	private int checkNext_prevIsUpper(char prev, int idx) {
		char next = input.charAt(idx);
		if(Character.isUpperCase(next)) { //다음 문자가 대문자인 경우
			answer.append(prev); //이전 문자를 붙인다.
		}
		else if(Character.isLowerCase(next)) { //다음 문자가 소문자인 경우
			if(alpha[next - 'a'] == 2) { //소문자 개수가 2개인 경우
				answer.append(prev).append(" "); //이전 문자를 넣어주고 분리한다.
			}
			else { //소문자 개수가 2개가 아닌 경우
				if(answer.length() > 0 && answer.charAt(answer.length() - 1) != ' ') {
                    answer.append(" ");
                }
				int num = alpha[next - 'a'];
				int start = idx - 1;
				int end = start + num * 2;
				if(visit[next - 'a'] || checkRangeOver(end)) {
					answer = new StringBuilder().append("invalid");
					exit = true;
				}
				
				boolean isWord = true;
				for(int j=start; j<end; j+=2) {
					char now = input.charAt(j);
					if(Character.isUpperCase(now) && input.charAt(j+1)==next) {
						answer.append(now);
					}
					else {
						isWord = false;
						break;
					}
				}
				
				if(isWord && Character.isUpperCase(input.charAt(end))) {
					answer.append(input.charAt(end)).append(" ");
					visit[next - 'a'] = true;
					return end;
				}
				else {
					answer = new StringBuilder().append("invalid");
					exit = true;
				}
			}
		}
		return idx;
	}
	
	private int checkNext_prevIsLower(char prev, int idx) {
		char next = input.charAt(idx);
		if(!visit[prev - 'a'] && alpha[prev - 'a']==2) {
			if(Character.isLowerCase(next)) { //다음 문자도 소문자면 규칙에 어긋남
				answer = new StringBuilder().append("invalid");
				exit = true;
			}
			else {
				int index = idx;
				int lowerCnt = 0, upperCnt = 0;
				char lower = ' ';
				boolean isWord = true;
				while(index < input.length() && input.charAt(index) != prev) {
					if(Character.isUpperCase(input.charAt(index))) {
						upperCnt++;
					}
					else {
						if(lower==' ') {
							lower = input.charAt(index);
						}
						else if(lower != input.charAt(index)) {
							isWord = false;
							break;
						}
						lowerCnt++;
					}
					index++;
				}
	
				if(lowerCnt==0) {
					for(int j=idx; j<index; j++) {
						answer.append(input.charAt(j));
					}
					return index;
				}
				else {
					if(isWord && lowerCnt + 1 == upperCnt) {
						if(!visit[lower - 'a']) {
							for(int j=idx; j<index-1; j+=2) {
								char now = input.charAt(j);
								if(Character.isUpperCase(now) && input.charAt(j+1)==lower) {
									answer.append(now);
								}
								else {
									isWord = false;
									break;
								}
							}
						}
					}
					else {
						isWord = false;
					}
					
					if(isWord) {
						answer.append(input.charAt(index-1)).append(" ");
						visit[lower - 'a'] = true;
						return index;
					}
					else {
						answer = new StringBuilder().append("invalid");
						exit = true;
					}
				}
			}
		}
		else {
			answer = new StringBuilder().append("invalid");
			exit = true;
		}
		return idx;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String sentence1 = "HaEaLaLaObWORLDb";
		String sentence2 = "SpIpGpOpNpGJqOqA";
		String sentence3 = "AxAxAxAoBoBoB";
		String sentence4 = "EoE";
		String sentence5 = "xAaAbAaAx";
		String sentence6 = "TxTxTxbAb";
		String sentence7 = "bTxTxTaTxTbkABaCDk";
		System.out.println(s.solution(sentence1));
	}

}
