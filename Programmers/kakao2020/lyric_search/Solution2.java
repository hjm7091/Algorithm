package lyric_search;

import java.util.HashMap;
import java.util.Map;

class Node {
	
	private final int alphaSize = 26;
	private char alpha;
	private Node[] child;
	private Map<Integer, Integer> frequencyMap; //<문자열 길이, 빈도수>
	private int depth;
	
	public Node(char alpha) {
		this.alpha = alpha;
		child = new Node[alphaSize];
		frequencyMap = new HashMap<>();
		depth = 0;
	}
	
	public Node getChild(int index) {
		return child[index];
	}
	
	public Node[] getChild() {
		return child;
	}
	
	public void setChild(int index, Node node, int depth) {
		child[index] = node;
		child[index].setDepth(depth);
	}
	
	public void recordLength(int length) {
		if(frequencyMap.containsKey(length))
			frequencyMap.put(length, frequencyMap.get(length) + 1);
		else
			frequencyMap.put(length, 1);
	}
	
	public int getFrequency(int length) {
		return frequencyMap.containsKey(length) ? frequencyMap.get(length) : 0;
	}
	
	public Map<Integer, Integer> getMap() {
		return frequencyMap;
	}
	
	public char getAlpha() {
		return alpha;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}

class Trie {
	
	private Node root;
	
	public Trie() {
		this.root = new Node('*');
	}
	
	public void insert(String word) {
		Node temp = root;
		
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int ascii = c - 'a';
			if(temp.getChild(ascii) == null) {
				Node node = new Node(c);
				temp.setChild(ascii, node, i+1);
				temp.recordLength(word.length());
				temp = node;
			}
			else {
				temp.recordLength(word.length());
				temp = temp.getChild(ascii);
			}
		}
	}
	
	public int search(String key) {
		int result = 0;
		Node temp = root;
		for(int i = 0; i < key.length(); i++) {
			if(key.charAt(i) == '?') {
				result = temp.getFrequency(key.length());
				break;
			}
			int ascii = key.charAt(i) - 'a';
			temp = temp.getChild(ascii);
			if(temp == null)
				return 0;
		}
		return result;
	}
	
	public void printNode(Node parent) {
		System.out.println(parent.getAlpha() + " " + parent.getDepth());
		System.out.println(parent.getMap());
		for(Node child : parent.getChild()) {
			if(child != null)
				printNode(child);
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
}

public class Solution2 {

	Trie trie, rtrie;
	Map<String, Integer> check;
	
	public int[] solution(String[] words, String[] queries) {
		init(words);
        int[] answer = new int[queries.length];
        count(queries, answer);
        return answer;
    }
	
	private void init(String[] words) {
		trie = new Trie();
		rtrie = new Trie();
		check = new HashMap<>();
		for(String word : words) {
			trie.insert(word);
			rtrie.insert(reverseString(word));
		}
	}
	
	private void count(String[] queries, int[] answer) {
		for(int i = 0; i < queries.length; i++) {
			String query = queries[i];
			if(check.containsKey(query))
				answer[i] = check.get(query);
			
			if(query.startsWith("?")) {
				answer[i] = rtrie.search(reverseString(query));
				check.put(query, answer[i]);
			}
			else {
				answer[i] = trie.search(query);
				check.put(query, answer[i]);
			}
		}
	}
	
	private String reverseString(String word) {
		return new StringBuffer(word).reverse().toString();
	}
}
