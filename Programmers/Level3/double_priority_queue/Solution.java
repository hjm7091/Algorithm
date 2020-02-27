package double_priority_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public int[] solution(String[] operations) {
        process(operations);
		int[] answer = new int[2];
		if(queue.size() > 0) {
			answer[0] = getMax();
			answer[1] = getMin();
		}
        return answer;
    }
	
	private void process(String[] operations) {
		for(String operation : operations) {
//			print();
			String[] op = operation.split(" ");
			if(op[0].equals("I")) 
				queue.add(Integer.parseInt(op[1]));
			else {
				if(op[1].equals("1")) 
					queue.remove(getMax());
				else
					queue.remove(getMin());
			}
		}
//		print();
	}
	
	private int getMax() {
		int max = Integer.MIN_VALUE;
		for(Iterator<Integer> it = queue.iterator(); it.hasNext();) {
			int now = it.next();
			max = Integer.max(max, now);
		}
		return max;
	}
	
	private int getMin() {
		int min = Integer.MAX_VALUE;
		for(Iterator<Integer> it = queue.iterator(); it.hasNext();) {
			int now = it.next();
			min = Integer.min(min, now);
		}
		return min;
	}
	
	private void print() {
		System.out.print("Queue : ");
		for(Iterator<Integer> it = queue.iterator(); it.hasNext();) {
			int now = it.next();
			System.out.print(now+" ");
		}
		System.out.println();
	}
	
}

