package baekjoon.bfs.q12906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("unchecked")
	static ArrayList<Character>[] stick = new ArrayList[3];
	static HashMap<State, Integer> check = new HashMap<>();
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i=0; i<3; i++) {
			stick[i] = new ArrayList<Character>();
			String[] splt = input.nextLine().split(" ");
			for(int j=0; j<Integer.parseInt(splt[0]); j++) 
				stick[i].add(splt[1].charAt(j));
		}
		bfs();
		System.out.println(result);
		input.close();
	}

	public static void bfs() {
		Queue<State> q = new LinkedList<State>();
		State state = new State(stick);
		q.add(state);
		check.put(state, 0);
		while(!q.isEmpty()) {
			State now = q.remove();
//			System.out.println(now.toString());
			if(checkEnd(now)) {
				result = check.get(now);
				break;
			}
			
			State AtoB = now.getCopy();
			if(Move(AtoB.stick[0], AtoB.stick[1]))
				update(now, AtoB, q);
			
			State AtoC = now.getCopy();
			if(Move(AtoC.stick[0], AtoC.stick[2]))
				update(now, AtoC, q);
			
			State BtoA = now.getCopy();
			if(Move(BtoA.stick[1], BtoA.stick[0]))
				update(now, BtoA, q);
			
			State BtoC = now.getCopy();
			if(Move(BtoC.stick[1], BtoC.stick[2]))
				update(now, BtoC, q);
			
			State CtoA = now.getCopy();
			if(Move(CtoA.stick[2], CtoA.stick[0]))
				update(now, CtoA, q);
			
			State CtoB = now.getCopy();
			if(Move(CtoB.stick[2], CtoB.stick[1]))
				update(now, CtoB, q);
		}
	}
	
	public static void update(State now, State next, Queue<State> q) {
		if(!check.containsKey(next)) {
			check.put(next, check.get(now) + 1);
			q.add(next);
		}
	}
	
	public static boolean Move(ArrayList<Character> src, ArrayList<Character> tar) {
		if(src.size()>=1) {
			char c = src.remove(src.size()-1);
			tar.add(c);
			return true;
		}
		else
			return false;
	}
	
	public static boolean checkEnd(State state) {
		for(char c : state.stick[0]) {
			if(c!='A')
				return false;
		}
		for(char c : state.stick[1]) {
			if(c!='B')
				return false;
		}
		for(char c : state.stick[2]) {
			if(c!='C')
				return false;
		}
		return true;
	}
	
}

class State {
	
	@SuppressWarnings("unchecked")
	ArrayList<Character>[] stick = new ArrayList[3];
	
	public State(ArrayList<Character>[] stick) {
		this.stick = stick;
	}
	
	public State getCopy() {
		@SuppressWarnings("unchecked")
		ArrayList<Character>[] copy = new ArrayList[3];
		for(int i=0; i<3; i++) {
			copy[i] = new ArrayList<>();
			copy[i].addAll(stick[i]);
		}
		return new State(copy);
	}
	
	@Override
	public boolean equals(Object obj) {
		State state = (State) obj;
		if(state.stick[0].size() != stick[0].size() ||
				state.stick[1].size() != stick[1].size() ||
					state.stick[2].size() != stick[2].size())
			return false;
		for(int i=0; i<3; i++) {
			for(int j=0; j<stick[i].size(); j++) {
				if(state.stick[i].get(j) != stick[i].get(j))
					return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return stick[0].hashCode() + stick[1].hashCode() + stick[2].hashCode();
	}
	
	@Override
	public String toString() {
		String[] str = new String[3];
		Arrays.fill(str, "");
		for(int i=0; i<3; i++) {
			for(char c : stick[i])
				str[i] += c;
		}
		return "stickA:" + str[0] + " stickB:" + str[1] + " stickC:" + str[2];
	}

}
