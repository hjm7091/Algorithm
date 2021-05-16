package Programmers.Level3.express_as_n;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

	HashSet<Integer> check = new HashSet<Integer>();
	@SuppressWarnings("unchecked")
	ArrayList<Integer>[] cache = new ArrayList[9];
    
    public int add(int left, int right) {
        return left + right;
    }
    
    public int sub(int left, int right) {
        return left - right;
    }
    
    public int mul(int left, int right) {
        return left * right;
    }
    
    public int div(int left, int right) {
        if (right == 0) return 0;
        return left / right;
    }
    
    public void put(int digit, int ret) {
        if (!check.contains(ret)) {
            check.add(ret);
            cache[digit].add(ret);
        }
    }
    
    public void cal(int digit, int left, int right) {
        put(digit, add(left, right));
        put(digit, sub(left, right));
        put(digit, mul(left, right));
        put(digit, div(left, right));
    }
    
    public int solution(int N, int number) {
        
        if (N==number) {
            return 1;
        }
        
        int temp = N;
        for (int i = 1; i < 9; i++) {
            if (temp == number) return i;
            cache[i] = new ArrayList<Integer>();
            cache[i].add(temp);
            check.add(temp);
            temp *= 10;
            temp += N;
        }
        
//        print();
        
        for (int digit = 1; digit < 9; digit++) {
            for (int i = 1; i < digit; i++) {
                int j = digit - i;
                for (int left : cache[i]) {
                    for (int right : cache[j]) {
//                    	System.out.println("i:"+i+" j:" +j+" digit:"+digit);
//                    	System.out.println("left:"+left+" right:"+right);
                        cal(digit, left, right);
//                        print();
                        if (check.contains(number)) {
                            return digit;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public void print() {
    	System.out.println(check);
        for(int i=1; i<9; i++) {
        	System.out.print(i+":");
        	for(int v : cache[i]) {
        		System.out.print(v+" ");
        	}
        	System.out.println();
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int answer = s.solution(5, 26);
		System.out.println(answer);
	}
}
