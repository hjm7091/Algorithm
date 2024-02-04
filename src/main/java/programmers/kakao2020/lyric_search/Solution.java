package programmers.kakao2020.lyric_search;

import java.util.*;

class Section {
	int left, right;
	int length;
	public Section(int left, int right, int length) {
		this.left = left;
		this.right = right;
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "left:" + left + " right:" + right + " length:" + length;
	}
}

public class Solution {
	
	List<Section> sections = new ArrayList<>();
	Map<String, Integer> map = new HashMap<>();
	
	Comparator<String> comp = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			return Integer.compare(s1.length(), s2.length());
		}
	};
	
	public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        makeSection(words);
        makeAnswer(words, queries, answer);
        return answer;
    }
	
	private void makeSection(String[] words) {
		Arrays.sort(words, comp);	
		int len = -1;
		int start = 0;
		int i;
		for(i = 0; i < words.length; i++) {
			if(i == 0) {
				len = words[i].length();
				continue;
			}
			if(len != words[i].length()) {
				sections.add(new Section(start, i-1, len));
				len = words[i].length();
				start = i;
			}
		}
		sections.add(new Section(start, i-1, len));	
	}
	
	private void makeAnswer(String[] words, String[] queries, int[] answer) {
		for(int i = 0; i < queries.length; i++) {
			String query = queries[i];
			
			if(map.containsKey(query)) {
				answer[i] = map.get(query);
				continue;
			}
			
			int section = findSection(query);
			if(section == -1) {
				answer[i] = 0;
				map.put(query, 0);
				continue;
			}
			
			Section s = sections.get(section);
			int cnt = 0;
			if(query.startsWith("?") && query.endsWith("?")) { 
				cnt = s.right - s.left + 1;
			}
			else if(query.startsWith("?")) {
				for(int j = s.left; j <= s.right; j++) {
					if(compareBack(words[j], query))
						cnt++;
				}
			}
			else if(query.endsWith("?")){
				for(int j = s.left; j <= s.right; j++) {
					if(compareFront(words[j], query))
						cnt++;
				}
			}
			
			answer[i] = cnt;
			map.put(query, cnt);
		}
	}
	
	private int findSection(String word) {
		int left = 0, right = sections.size() - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			int midLength = sections.get(mid).length;
			if(word.length() == midLength) {
				return mid;
			}
			else if(word.length() < midLength) {
				right = mid -1;
			}
			else
				left = mid + 1;
		}
		return -1;
	}
	
	private boolean compareBack(String word, String query) {
		for(int i = query.length()-1; i >= 0; i--) {
			char w = word.charAt(i);
			char q = query.charAt(i);
			if(q == '?')
				break;
			if(w != q)
				return false;
		}
		return true;
	}
	
	private boolean compareFront(String word, String query) {
		for(int i = 0; i < query.length(); i++) {
			char w = word.charAt(i);
			char q = query.charAt(i);
			if(q == '?')
				break;
			if(w != q)
				return false;
		}
		return true;
	}
}
