package Programmers.kakao2023.maze_escape_command;

public class Solution {

    String path = null;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        search(n, m, x, y, r, c, k, new StringBuilder());
        return path == null ? "impossible" : path;
    }

    private void search(int n, int m, int x, int y, int r, int c, int k, StringBuilder sb) {
        if (path != null) return;
        if (x <= 0 || x > n || y <= 0 || y > m) return;
        int dis = Math.abs(x - r) + Math.abs(y - c);
        if (k < dis || (k - dis) % 2 == 1) return;
        if (k < 0) return;
        if (k == 0 && x == r && y == c) {
            path = sb.toString();
            return;
        }

        sb.append("d");
        search(n, m, x + 1, y, r, c, k - 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("l");
        search(n, m, x, y - 1, r, c, k - 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("r");
        search(n, m, x, y + 1, r, c, k - 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("u");
        search(n, m, x - 1, y, r, c, k - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

}
