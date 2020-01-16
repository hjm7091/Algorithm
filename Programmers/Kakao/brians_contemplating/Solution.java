package brians_contemplating;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	Map<Character, Integer> alpha = new HashMap<Character, Integer>();
	
	public String solution(String sentence) {
		countLowAlpha(sentence);
		System.out.println(alpha);
		System.out.println(sentence);
		lookMap(sentence);
		String answer = "";
		return answer;
		
	}
	
	private void countLowAlpha(String sentence) {
		for(int idx=0; idx<sentence.length(); idx++) {
			char nowChar = sentence.charAt(idx);
			if(Character.isLowerCase(nowChar)) {
				if(alpha.containsKey(nowChar)) 
					alpha.put(nowChar, alpha.get(nowChar) + 1);
				else 
					alpha.put(nowChar, 1);
			}
		}
	}
	
	private void lookMap(String sentence) {
		for(Map.Entry<Character, Integer> entry : alpha.entrySet()) {
			char alpha = entry.getKey();
			int count = entry.getValue();
			int startIdx = sentence.indexOf(alpha) - 1;
			int endIdx = sentence.lastIndexOf(alpha) + 1;
			String word1 = "", word2 = "";
			if(count==2) {
				if(isPossibleUndoRule1(sentence, alpha, startIdx, endIdx))
					word1 = undoRule1(sentence, alpha, startIdx, endIdx);
				word2 = undoRule2(sentence, alpha, startIdx, endIdx);
			}
			else {
				if(isPossibleUndoRule1(sentence, alpha, startIdx, endIdx))
					word1 = undoRule1(sentence, alpha, startIdx, endIdx);
			}
			System.out.println("word1:" + word1);
			System.out.println("word2:" + word2);
			System.out.println();
		}
	}
	
	private boolean isPossibleUndoRule1(String sentence, char alpha, int start, int end) {
		if(sentence.length()<=2)
			return false;
		for(int idx=start; idx<=end; idx++) {
			char nowChar = sentence.charAt(idx);
			if(Character.isLowerCase(nowChar)) {
				if(nowChar==alpha) {
					int left = idx - 1;
					int right = idx + 1;
					if(checkRangeOver(sentence, left, right))
						return false;
					char leftChar = sentence.charAt(left);
					char rightChar = sentence.charAt(right);
					if(!Character.isUpperCase(leftChar) || !Character.isUpperCase(rightChar))
						return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkRangeOver(String sentence, int left, int right) {
		if(left<0 || right>=sentence.length())
			return true;
		return false;
	}
	
//	private boolean isPossibleUndoRule2(String sentence, char alpha) {
//		int beginIdx = sentence.indexOf(alpha);
//		int endIdx = sentence.lastIndexOf(alpha);
//		String word = sentence.substring(beginIdx+1, endIdx);
//		if(word.equals(""))
//			return false;
//		else
//			return true;
//	}
	
	private String undoRule1(String sentence, char alpha, int start, int end) {
		String word = "";
		for(int idx=start; idx<=end; idx++) {
			char nowChar = sentence.charAt(idx);
			if(Character.isUpperCase(nowChar)) 
				word += nowChar;
			else {
				if(nowChar==alpha)
					continue;
				else
					break;
			}
		}
		return word;
	}
	
	private String undoRule2(String sentence, char alpha, int start, int end) {
		return sentence.substring(start + 2, end - 1);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String sentence1 = "HaEaLaLaObWORLDb";
		String sentence2 = "SpIpGpOpNpGJqOqA";
		String sentence3 = "AxAxAxAoBoBoB";
		System.out.println(s.solution(sentence3));
	}

}
