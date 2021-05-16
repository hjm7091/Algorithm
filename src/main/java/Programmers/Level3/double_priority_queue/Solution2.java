package Programmers.Level3.double_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution2 {

	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //우선 순위 큰 것 : 작은 수
	PriorityQueue<Integer> rpq = new PriorityQueue<Integer>(Collections.reverseOrder()); //우선 순위 큰 것 : 큰 수
	
	public int[] solution(String[] operations) {
        for(String operation : operations) {
        	String[] op = operation.split(" ");
        	if(op[0].equals("I")) {
				pq.add(Integer.parseInt(op[1]));
				rpq.add(Integer.parseInt(op[1]));
        	}
			else {
				if(pq.size() > 0) {
					if(op[1].equals("1")) {
						int max = rpq.poll();
						pq.remove(max);
					}
					else {
						int min = pq.poll();
						rpq.remove(min);
					}
				}
			}
        }
		int[] answer = new int[2];
		if(pq.size() > 0) {
			answer[0] = rpq.poll();
			answer[1] = pq.poll();
		}
        return answer;
    }
	
}
