package rank_search;

import java.util.*;

public class Solution {

	private Map<String, List<Integer>> dic = new HashMap<>();
	
	private int[][] barIndexes = {
		{0}, {1}, {2}, {3},
		{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3},
		{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3},
		{0, 1, 2, 3}
	};
	
	public int[] solution(String[] info, String[] query) {
		for(String i : info) {
			String[] items = i.split(" ");
			
			String key = makeKey(Arrays.copyOf(items, items.length - 1), new int[] {});
			int score = Integer.parseInt(items[4]);
			record(key, score);
			
			for(int[] barIndex : barIndexes) {
				key = makeKey(Arrays.copyOf(items, items.length - 1), barIndex);
				record(key, score);
			}
		}
		
		dic.forEach((k, v) -> {
			Collections.sort(v);
		});
		
		List<Integer> resultList = new ArrayList<>();
		
		for (String q : query) {
			q = q.replace(" and ", "");
			String[] items = q.split(" ");
			String key = items[0];
			int score = Integer.parseInt(items[1]);

            List<Integer> scores = dic.getOrDefault(key, new ArrayList<Integer>());

            int left = 0, right = scores.size();
            
            while(left < right) {
            	int mid = (left + right) / 2;
            	if(scores.get(mid) < score) left = mid + 1;
            	else right = mid;
            }

            resultList.add(scores.size() - left);
        }

		return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
	
	private void record(String key, int score) {
		List<Integer> scores = dic.getOrDefault(key, new ArrayList<Integer>());
		scores.add(score);
		dic.put(key, scores);
	}

	private String makeKey(String[] items, int[] indexes) {
		for(int index : indexes) {
			items[index] = "-";
		}
		
		StringBuilder sb = new StringBuilder();
		for(String item : items) {
			sb.append(item);
		}
		
		return sb.toString();
	}
}
