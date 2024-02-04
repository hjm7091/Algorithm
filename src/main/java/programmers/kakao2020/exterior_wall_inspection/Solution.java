package programmers.kakao2020.exterior_wall_inspection;

import java.util.*;

public class Solution {

	int[] dist;
	boolean[] distVisit; //순열을 만들 때 사용할 배열
	int n;
	int answer = Integer.MAX_VALUE;
	List<Integer> friends = new ArrayList<Integer>(); //사용할 친구들을 저장
	List<Integer> weakPoints = new ArrayList<Integer>(); //취약점들을 저장
	
	public int solution(int n, int[] weak, int[] dist) {
		init(n, weak, dist);
		for(int numOfFriends = 1; numOfFriends <= dist.length; numOfFriends++) 
			makePermutation(numOfFriends);
		if(answer == Integer.MAX_VALUE)
			return -1;
		else
			return answer;
    }
	
	private void init(int n, int[] weak, int[] dist) {
		this.n = n;
		Arrays.sort(dist);
		this.dist = dist;
		distVisit = new boolean[dist.length];
		for(int w : weak) 
			weakPoints.add(w);
	}
	
	private void makePermutation(int num) {
		if(friends.size() == num) {
			//취약 지점 복사
			List<Integer> weakList = new ArrayList<>();
			weakList.addAll(weakPoints);
			
			for(int i = 0; i < weakList.size(); i++) {
				//사용할 친구 복사
				List<Integer> friendList = new ArrayList<>();
				friendList.addAll(friends);
				int usedNum = friendList.size();
				
				if(canInspectAll(friendList, weakList))
					answer = Integer.min(answer, usedNum);
				
				//취약 지점 갱신
				weakList.add(weakList.get(0) + n);
				weakList.remove(0);
			}
			return;
		}
		for(int i = 0; i < distVisit.length; i++) {
			if(!distVisit[i]) {
				distVisit[i] = true;
				friends.add(dist[i]);
				makePermutation(num);
				friends.remove(friends.size() - 1);
				distVisit[i] = false;
			}
		}
	}
	
	private boolean canInspectAll(List<Integer> friendList, List<Integer> weakList) {
		Integer[] weakArray = weakList.toArray(new Integer[weakList.size()]);
		boolean[] weakVisit = new boolean[weakList.size()];
		
		while(friendList.size() > 0) { //사용할 친구가 있다면
			int friendToUse = friendList.get(0);
			friendList.remove(0);
			int idx = getUnInspectIdx(weakVisit); //최초의 검사되지 않은 지점을 반환
			if(idx == -1) //검사되지 않은 지점이 없다면
				break;
			int from = weakArray[idx];
			int to = from + friendToUse;
			inspect(weakArray, weakVisit, from, to); //from ~ to에 속하는 지점을 체크해줌
		}
		
		for(int i = 0; i < weakVisit.length; i++)
			if(weakVisit[i] == false)
				return false;
		return true;
	}
	
	private int getUnInspectIdx(boolean[] visit) {
		int idx = -1;
		for(int i = 0; i < visit.length; i++) {
			if(visit[i] == false) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	private void inspect(Integer[] weak, boolean[] visit, int from, int to) {
		for(int i = 0; i < visit.length; i++) {
			if(visit[i])
				continue;
			if(weak[i] >= from && weak[i] <= to)
				visit[i] = true;
		}
	}
	
}
