package Programmers.kakao2021.recommend_new_id;

import static java.lang.Character.*;

public class Solution {

	public String solution(String new_id) {
        
        //step1
        new_id = new_id.toLowerCase();
        // System.out.printf("after step1 : %s\n", new_id);
        
        //step2
        StringBuilder step2 = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(isLetter(c) || isDigit(c) || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }
        new_id = step2.toString();
        // System.out.printf("after step2 : %s\n", new_id);
        
        //step3
        while(new_id.indexOf("..") != -1) {
            new_id = new_id.replace("..", ".");   
        }
        // System.out.printf("after step3 : %s\n", new_id);
        
        //step4
        if(new_id.startsWith(".") && new_id.length() > 0) {
            new_id = new_id.substring(1);
        } 
        if(new_id.endsWith(".") && new_id.length() > 0) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // System.out.printf("after step4 : %s\n", new_id);
        
        //step5
        if(new_id.length() == 0) {
            new_id = "a";
        }
        // System.out.printf("after step5 : %s\n", new_id);
        
        //step6
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        // System.out.printf("after step6 : %s\n", new_id);
        
        //step7
        if(new_id.length() < 3) {
            String last = String.valueOf(new_id.charAt(new_id.length() - 1));
            while(new_id.length() < 3) {
                new_id += last;
            }
        }
        // System.out.printf("after step7 : %s\n", new_id);
        
        String answer = new_id;
        return answer;
    }
	
}
