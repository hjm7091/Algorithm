package programmers.level3.travel_route;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
	
	private Solution s = new Solution();
	
	@Test
	public void case1() {
		String[][] tickets = {{"ICN","JFK"}, {"HND","IAD"}, {"JFK","HND"}};
		String[] result = s.solution(tickets);
		String[] expectedResult = {"ICN", "JFK", "HND", "IAD"};
		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void case2() {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] result = s.solution(tickets);
		String[] expectedResult = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
		assertArrayEquals(expectedResult, result);
	}
}
