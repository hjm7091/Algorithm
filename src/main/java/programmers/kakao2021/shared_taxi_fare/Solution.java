package programmers.kakao2021.shared_taxi_fare;

/*
 * Floyd Warshall 알고리즘
 */
public class Solution {
	
	final int INF = 200 * 100000; 
	
    public int solution(int n, int s, int a, int b, int[][] fares) {

    	int[][] d = new int[n + 1][n + 1];
    	
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(i == j) d[i][j] = 0;
    			else d[i][j] = INF;
    		}
    	}
    	
    	printArray("init", d);
    	
    	for(int[] fare : fares) {
    		int from = fare[0], to = fare[1], cost = fare[2];
    		d[from][to] = cost;
    		d[to][from] = cost;
    	}
    	
    	printArray("before floyd", d);
    	
    	for(int k = 1; k <= n; k++) {
    		for(int i = 1; i <= n; i++) {
    			for(int j = 1; j <= n; j++) {
    				d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
    			}
    		}
    		printArray("after step k : " + k, d);
    	}
    	
    	int result = Integer.MAX_VALUE;
    	
    	for(int k = 1; k <= n; k++) {
    		result = Math.min(result, d[s][k] + d[k][a] + d[k][b]);
    	}
    	
    	return result;
	}
    
    private void printArray(String msg, int[][] array) {
    	System.out.println(msg);
    	for(int i = 1; i < array.length; i++) {
    		for(int j = 1; j < array.length; j++) {
    			if(array[i][j] == INF) System.out.print("-1 ");
    			else System.out.print(array[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }

}
