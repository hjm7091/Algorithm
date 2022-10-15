package Baekjoon.Deque.q5430;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class AC {
        private final String p;
        private final Deque<Integer> deque = new ArrayDeque<>();
        private boolean dir;

        public AC(String p, int[] arr) {
            this.p = p;
            this.deque.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            this.dir = true;
        }

        public String runP() {
            try {
                for (char each : this.p.toCharArray()) {
                    if (each == 'R') dir = !dir;
                    else drop();
                }
            } catch (Exception e) {
                return "error";
            }
            List<Integer> result = new ArrayList<>();
            while (!deque.isEmpty()) {
                if (dir) result.add(deque.removeFirst());
                else result.add(deque.removeLast());
            }
            return result.toString().replaceAll(" ", "");
        }

        private void drop() {
            if (deque.size() == 0) throw new IllegalStateException("empty..");
            if (dir) deque.removeFirst();
            else deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); sc.nextLine();
        List<String> result = new ArrayList<>();
        while (T-- > 0) {
            String p = sc.next(); sc.nextLine();
            int n = sc.nextInt(); sc.nextLine();
            String arrStr = sc.next(); sc.nextLine();
            int[] arr = n == 0 ? new int[0] : Arrays.stream(arrStr.substring(1, arrStr.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
            result.add(new AC(p, arr).runP());
        }
        result.forEach(System.out::println);
    }

}
