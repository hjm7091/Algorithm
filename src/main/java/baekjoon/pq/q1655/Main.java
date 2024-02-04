package baekjoon.pq.q1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 참고 : <a href="https://codingwell.tistory.com/80"></a>
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> min_pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max_pq.size() > min_pq.size()) min_pq.offer(num);
            else max_pq.offer(num);

            if (!min_pq.isEmpty() && !max_pq.isEmpty()) {
                if (min_pq.peek() < max_pq.peek()) {
                    Integer min_pq_v = min_pq.poll();
                    Integer max_pq_v = max_pq.poll();
                    min_pq.offer(max_pq_v);
                    max_pq.offer(min_pq_v);
                }
            }

            sb.append(max_pq.peek()).append("\n");
        }
        System.out.print(sb);
    }

}
