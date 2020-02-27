package double_priority_queue;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest2 {
	
	private Solution2 s = new Solution2();
	
	@Test
	public void case1() {
		String[] operations = {"I 16", "D 1"};
		int[] result = s.solution(operations);
		int[] expected = {0, 0};
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void case2() {
		String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		int[] result = s.solution(operations);
		int[] expected = {7, 5};
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void case3() {
		String[] operations = {"D -1"};
		int[] result = s.solution(operations);
		int[] expected = {0, 0};
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void case4() {
		String[] operations = {"I -1"};
		int[] result = s.solution(operations);
		int[] expected = {-1, -1};
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void case5() {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		int[] result = s.solution(operations);
		int[] expected = {333, -45};
		Assert.assertArrayEquals(expected, result);
	}
}
