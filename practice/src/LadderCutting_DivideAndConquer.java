import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LadderCutting_DivideAndConquer {

	static int[] h; //각 판자의 높이를 저장하는 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = Integer.parseInt(input.readLine());
		for(int i=0; i<c; i++) {
			int n = Integer.parseInt(input.readLine());
			StringTokenizer st = new StringTokenizer(input.readLine());
			h = new int[n];
			for(int j=0; j<n; j++)
				h[j] = Integer.parseInt(st.nextToken());
			int result = solve(0,n-1);
			output.write(result+"\n");
		}
		output.flush();
		output.close();
	}
	
	public static int solve(int left, int right) { //h[left...right]구간에서 찾아낼 수 있는 가장 큰 사각형의 넓이 반환
		if(left==right) //기저 사례:판자가 하나밖에 없는 경우
			return h[left];
		int mid = (left+right)/2; //[left,mid],[mid+1,right]의 두 구간으로 문제를 분할
		int ret = Integer.max(solve(left,mid), solve(mid+1,right)); //분할한 문제를 각개격파
		int lo = mid, hi = mid+1;
		int height = Integer.min(h[lo], h[hi]); 
		ret = Integer.max(ret, 2*height); //[mid,mid+1]만 포함하는 너비 2인 사각형을 고려
		while(left < lo || hi < right) { //두 부분에 모두 걸치는 사각형 중 가장 큰 것을 찾는다, 항상 높이가 더 높은 쪽으로 확장
			if(left < lo && (hi == right || h[lo-1] > h[hi+1])) {
				--lo;
				height = Integer.min(height, h[lo]);
			}
			else {
				++hi;
				height = Integer.min(height, h[hi]);
			}
			ret = Integer.max(ret, height*(hi-lo+1)); //확장한 후 사각형의 넓이
		}
		return ret;
	}

}
