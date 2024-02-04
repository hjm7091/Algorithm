package study.algorithm_problem_solving_strategy.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(9);
		System.out.println("before");
		for(int i : list) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("after");
		list.remove(2);
		for(int i : list) {
			System.out.print(i+" ");
		}
	}

}
