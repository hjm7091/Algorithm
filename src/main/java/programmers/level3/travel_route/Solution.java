package programmers.level3.travel_route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	
	int N;
	boolean[] visit;
	String[][] tickets;
	List<String> routes;
	
	public String[] solution(String[][] tickets) {
		init(tickets);
		makeAllRoute("ICN", "ICN");
		String[] answer = makeResultArray();
        return answer;
    }
	
	private void init(String[][] tickets) {
		N = tickets.length;
		visit = new boolean[N];
		routes = new ArrayList<String>();
		this.tickets = tickets;
	}
	
	private void makeAllRoute(String start, String nowRoute) {
		if(visitAll()) {
//			System.out.println(nowRoute);
			routes.add(nowRoute);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visit[i] && tickets[i][0].equals(start)) {
				visit[i] = true;
//				String nextRoute = nowRoute + "->" + tickets[i][1];
				String nextRoute = nowRoute + tickets[i][1];
				makeAllRoute(tickets[i][1], nextRoute);
				visit[i] = false;
			}
		}
	}
	
	private boolean visitAll() {
		for(int i = 0; i < N; i++) 
			if(visit[i] == false)
				return false;
		return true;
	}
	
	private String[] makeResultArray() {
		Collections.sort(routes);
		String result = routes.get(0);
        String[] arr = new String[result.length() / 3];
        for(int i = 0, j = 0; i < result.length(); i+=3, j++) {
        	String airport = result.substring(i, i+3);
        	arr[j] = airport;
        }
        return arr;
	}
	
}
