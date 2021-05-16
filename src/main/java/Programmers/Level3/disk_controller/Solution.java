package Programmers.Level3.disk_controller;

import java.util.*;

class Task {
	int requestTime;
	int timeRequired;
	public Task(int requestTime, int timeRequired) {
		this.requestTime = requestTime;
		this.timeRequired = timeRequired;
	}
	
	@Override
	public String toString() {
		return "[request:" + requestTime + " required:" + timeRequired + "]"; 
	}
}

public class Solution {

	private List<Task> tasks = new ArrayList<Task>();
	private int N;
	
	public int solution(int[][] jobs) {
		init(jobs);
        return calculateMinimumAverageTime();
    }
	
	private void init(int[][] jobs) {
		for(int i = 0; i < jobs.length; i++) 
			tasks.add(new Task(jobs[i][0], jobs[i][1]));
		N = tasks.size();
	}
	
	private int calculateMinimumAverageTime() {
		int totalTakenTime = 0;
		int time = 0;

		while(tasks.size() > 0) {
//			printTasks();
			Task task = findTopPriorityTask(time);
			if(task == null) 
				time++;
			else {
				time += task.timeRequired;
				int takenTime = time - task.requestTime;
				totalTakenTime += takenTime;
				tasks.remove(task);
			}
		}
		
		return totalTakenTime / N;
	}
	
	private Task findTopPriorityTask(int nowTime) {
		Task topPrioritytask = null;
		for(Task task : tasks) {
			if(topPrioritytask == null && task.requestTime <= nowTime)
				topPrioritytask = task;
			else if(task.requestTime <= nowTime && 
						task.timeRequired < topPrioritytask.timeRequired) {
				topPrioritytask = task;
			}
		}
		return topPrioritytask;
	}
	
	private void printTasks() {
		for(Task task : tasks) {
			System.out.print(task.toString() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] jobs1 = {{0, 3}, {1, 9}, {2, 6}};
		int[][] jobs2 = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};
		int[][] jobs3 = {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}};
		int[][] jobs4 = {{0, 6}, {0, 8}, {7, 1}};
		System.out.println(s.solution(jobs4));
	}

}
