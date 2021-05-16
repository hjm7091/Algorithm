package Programmers.kakao2021.menu_renewal;

import java.util.*;

class Info {
    String menu;
    int count;
    Info(String menu, int count) {
        this.menu = menu;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return menu + " : " + count;
    }
}

public class Solution {
    
    Map<String, Integer> candidates = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for(String order : orders) {
            for(int num : course) {
                makeAllCandidate(-1, order, new boolean[order.length()], new ArrayList<Character>(), num);
            }
        }
        
		Map<Integer, List<Info>> coursesBySize = new HashMap<>();
		
		candidates.forEach((menu, count) -> {
			if(count > 1) {
				List<Info> courses = coursesBySize.getOrDefault(menu.length(), new ArrayList<Info>());
				courses.add(new Info(menu, count));
				coursesBySize.put(menu.length(), courses);
			}
		});
		
		List<String> result = new ArrayList<>();
		
		coursesBySize.forEach((size, infoList) -> {
			
			Collections.sort(infoList, new Comparator<Info>() {

				@Override
				public int compare(Info info1, Info info2) {
					return info2.count - info1.count;
				}
			});
			
			Info first = infoList.get(0);
			result.add(first.menu);
			
			for(int i = 1; i < infoList.size(); i++) {
				Info info = infoList.get(i);
				if(info.count == first.count) {
					result.add(info.menu);
				} else {
					break;
				}
			}
			
		});
		
		Collections.sort(result);
		
        return result.stream().toArray(String[]::new);
    }
    
    private void makeAllCandidate(int idx, String order, boolean[] visit, List<Character> choices, int targetSize) {
        if(choices.size() == targetSize) {
            String menu = "";
            for(char choice : choices) {
                menu += choice;
            }
            
            menu = menu.chars()
                       .sorted()
                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                       .toString();
            
            candidates.put(menu, candidates.getOrDefault(menu, 0) + 1);
        }
        
        for(int i = idx + 1; i < order.length(); i++) {
            if(visit[i] == false) {
                visit[i] = true;
                choices.add(order.charAt(i));
                makeAllCandidate(i, order, visit, choices, targetSize);
                choices.remove(choices.size() - 1);
                visit[i] = false;
            }
        }
    }
}
