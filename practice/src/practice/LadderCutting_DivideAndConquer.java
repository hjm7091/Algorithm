package practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LadderCutting_DivideAndConquer {

	static int[] h; //�� ������ ���̸� �����ϴ� �迭
	
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
	
	public static int solve(int left, int right) { //h[left...right]�������� ã�Ƴ� �� �ִ� ���� ū �簢���� ���� ��ȯ
		if(left==right) //���� ���:���ڰ� �ϳ��ۿ� ���� ���
			return h[left];
		int mid = (left+right)/2; //[left,mid],[mid+1,right]�� �� �������� ������ ����
		int ret = Integer.max(solve(left,mid), solve(mid+1,right)); //������ ������ ��������
		int lo = mid, hi = mid+1;
		int height = Integer.min(h[lo], h[hi]); 
		ret = Integer.max(ret, 2*height); //[mid,mid+1]�� �����ϴ� �ʺ� 2�� �簢���� ���
		while(left < lo || hi < right) { //�� �κп� ��� ��ġ�� �簢�� �� ���� ū ���� ã�´�, �׻� ���̰� �� ���� ������ Ȯ��
			if(left < lo && (hi == right || h[lo-1] > h[hi+1])) {
				--lo;
				height = Integer.min(height, h[lo]);
			}
			else {
				++hi;
				height = Integer.min(height, h[hi]);
			}
			ret = Integer.max(ret, height*(hi-lo+1)); //Ȯ���� �� �簢���� ����
		}
		return ret;
	}

}
