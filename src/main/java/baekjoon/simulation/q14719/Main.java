package baekjoon.simulation.q14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			bufferedReader.readLine();
			int[] map = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int leftH = 0, rightH = 0, result = 0;
			for (int i = 1; i < map.length - 1; i++) {
				leftH = findMax(map, 0, i - 1);
				rightH = findMax(map, i + 1, map.length - 1);
				if (map[i] < leftH && map[i] < rightH) {
					result += (Math.min(leftH, rightH) - map[i]);
				}
			}

			System.out.println(result);
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	private static int findMax(int[] map, int start, int end) {
		int max = -1;
		for (int i = start; i <= end; i++) {
			if (map[i] > max) {
				max = map[i];
			}
		}
		return max;
	}
}
