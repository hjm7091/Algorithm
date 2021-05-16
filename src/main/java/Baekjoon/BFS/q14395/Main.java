package Baekjoon.BFS.q14395;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int s, t;
	static String result;
	static final long MAX = 1000000000L;
	static Map<Long, ArrayList<String>> visit = new HashMap<>();
	static char[] operator = {'*', '+', '-', '/'};
	
	public static void main(String[] args) {
		input();
		performBfs();
		output();
	}
	
	private static void input() {
		Scanner input = new Scanner(System.in);
		s = input.nextInt();
		t = input.nextInt();
		input.close();
	}
	
	private static void performBfs() {
		if(s==t) 
			return;
		Queue<Long> q = new LinkedList<>();
		q.add((long)s);
		ArrayList<String> empty = new ArrayList<>();
		empty.add("");
		visit.put((long)s, empty);
		while(!q.isEmpty()) {			
			long now = q.remove();
			ArrayList<String> nowOperatorsList = visit.get(now);	
			for(int idx=0; idx<4; idx++) {
				for(String operators : nowOperatorsList) {
					long nextValue = calculateNextValue(idx, now);	
					String nextOperators = operators + operator[idx];
					if(nextValue==-1)
						continue;
					if(nextValue > MAX)
						continue;
					if(visit.containsKey(nextValue)) {
						ArrayList<String> nextOperatorsList = visit.get(nextValue);
						String sample = nextOperatorsList.get(0);
						if(nextOperators.length() < sample.length()) {
							nextOperatorsList.clear();
							nextOperatorsList.add(nextOperators);
							visit.put(nextValue, nextOperatorsList);
							q.add(nextValue);
						}
					}
					else {
						ArrayList<String> nextOperatorsList = new ArrayList<>();
						nextOperatorsList.add(nextOperators);
						visit.put(nextValue, nextOperatorsList);
						q.add(nextValue);
					}
				}
			}
//			System.out.println(visit.toString());
		}
	}
	
	private static long calculateNextValue(int idx, long now) {
		if(idx==0) 
			return now * now;
		else if(idx==1)
			return now + now;
		else if(idx==2)
			return now - now;
		else if(idx==3 && now!=0)
			return now / now;
		return -1;
	}
	
	private static void output() {
		if(s==t) {
			System.out.println("0");
			return;
		}
		if(visit.containsKey((long)t)) {
			ArrayList<String> resultList = visit.get((long)t);
			if(resultList.size() > 1)
				Collections.sort(resultList);
			result = resultList.get(0);
		}
		else
			result = "-1";
		System.out.println(result);
	}

}
