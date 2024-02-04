package programmers.kakao2021.ad_insertion;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 시작이 0부터이므로 광고 시간이 00:14:15라면
 * 00:00:00 ~ 00:14:15가 아니라
 * 00:00:00 ~ 00:14:14가 맞음
 * long을 사용 해야 testCase 17번 통과함
 * long만 사용하면 시간 초과남
 */
public class Solution {
	
	long[] ad = new long[360000];
	
    public String solution(String play_time, String adv_time, String[] logs) {
        
        for(String log : logs) {
        	String[] splits = log.split("-");
        	int start = (int) stringToLong(splits[0]);
        	int end = (int) stringToLong(splits[1]);
        	for(int i = start; i < end; i++) {
        		ad[i]++;
        	}
        }
        
        int playTime = (int) stringToLong(play_time);
        int advTime = (int) stringToLong(adv_time);
        
        Queue<Long> q = new LinkedList<>();

        long maxCumulativeTime = 0;
        long cumulativeTime = 0;
        long maxIdx = 0;
        
        for(int i = 0; i < advTime; i++) {
        	cumulativeTime += ad[i];
        	q.add(ad[i]);
        }
        
        maxCumulativeTime = cumulativeTime;
        
        for(int i = advTime; i <= playTime; i++) {
        	cumulativeTime += ad[i];
        	q.add(ad[i]);
        	long front = q.poll();
        	cumulativeTime -= front;
        	
//        	System.out.println("start : " + longToString(i - advTime + 1) + ", end : " + longToString(i) + ", cumulativeTime : " + longToString(cumulativeTime));
        	
        	if(cumulativeTime > maxCumulativeTime) {
        		maxIdx = i - advTime + 1;
        		maxCumulativeTime = cumulativeTime;
        	}
        }
        
        return longToString(maxIdx);
    }
    
	private long stringToLong(String time) {
    	String[] splits = time.split(":");
    	long hh = Long.parseLong(splits[0]) * 3600;
    	long mm = Long.parseLong(splits[1]) * 60;
    	long ss = Long.parseLong(splits[2]);
    	return hh + mm + ss;
    }
	
	private String longToString(long time) {
		long hh = 0, mm = 0, ss = 0;

		if(time >= 3600) {
			hh = time / 3600;
			time = time % 3600;
		} 
		
		if(time >= 60) {
			mm = time / 60;
			time = time % 60;
		}
		
		ss = time;
		
		return String.format("%02d:%02d:%02d", hh, mm, ss);
	}
}
