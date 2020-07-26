package q19235;

import java.util.Scanner;

public class Main {

    private static int blockCount = 0, totalScore = 0, blockNum = 1;
    private static int[][][] area = new int[10][4][2];
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        for(int i = 0; i < N; i++) {
            int t = input.nextInt(); int x = input.nextInt(); int y = input.nextInt();
            sendBlock(t, x, y);
            removeFullLine();
            checkSpecialLine();
        }
        System.out.println(totalScore);
        System.out.println(blockCount);
        input.close();
    }

    private static void checkSpecialLine() {
        for (int color = 0; color < 2; color++) {
            int count = 0;
            for (int sp = 4; sp < 6; sp++) {
                for(int i = 0; i < 4; i++) {
                    if (area[sp][i][color] != 0) {
                        count++;
                        break;
                    }
                }
            }

            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    remove(9, color);
                    move(9, color);
                }
            }
        }
    }

    private static void removeFullLine() {
        boolean flag = false;
        for (int color = 0; color < 2; color++) {
            for (int i = 6; i < 10; i++) {
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    if (area[i][j][color] != 0)
                        count++;
                }
                if (count == 4) {
                    flag = true;
                    totalScore++;
                    remove(i, color);
                    move(i, color);
                }
            }
        }

        if (flag)
            removeFullLine();
    }

    private static void move(int idx, int color) {
        if (idx == 3)
            return;

        int moveIdx = idx - 1;
        for (int i = 0; i < 4; i++) {
            if (area[moveIdx][i][color] == 0)
                continue;

            int x = moveIdx;
            int y = i;
            int value = area[x][y][color];
            boolean flag = false;

            for (int dir = 0; dir < 4; dir++) {
                int nx = moveIdx + dy[dir];
                int ny = y + dx[dir];

                if (!rangeOver(nx, ny)) {

                    if (area[x][y][color] == area[nx][ny][color]) {
                        flag = true;
                        int tmpX = x + 1;
                        int count1 = 1;
                        while (true) {
                            if (tmpX < 10 && area[tmpX][y][color] == value) {
                                count1 = Integer.MAX_VALUE;
                                break;
                            }
                            if (tmpX >= 10 || area[tmpX][y][color] != 0)
                                break;
                            tmpX++;
                            count1++;
                        }
                        count1--;

                        int tmpNx = nx + 1;
                        int count2 = 1;
                        while (true) {
                            if (tmpNx < 10 && area[tmpNx][ny][color] == value) {
                                count2 = Integer.MAX_VALUE;
                                break;
                            }
                            if (tmpNx >= 10 || area[tmpNx][ny][color] != 0)
                                break;
                            tmpNx++;
                            count2++;
                        }
                        count2--;

                        int moveCount = Integer.min(count1, count2);
                        area[x + moveCount][y][color] = area[x][y][color];
                        area[nx + moveCount][ny][color] = area[nx][ny][color];
                        if (nx + moveCount == x)
                            area[x][y][color] = 0;
                        else
                            area[x][y][color] = area[nx][ny][color] = 0;

                        break;
                    }

                }
            }

            if (!flag) {
                int tmpX = x + 1;
                int count = 1;
                while (tmpX < 10 && area[tmpX][y][color] == 0) {
                    tmpX++;
                    count++;
                }
                count--;

                area[x + count][y][color] = area[x][y][color];
                area[x][y][color] = 0;
            }
        }

        move(idx - 1, color);
    }

    private static boolean rangeOver(int nx, int ny) {
        return nx < 4 || nx > 9 || ny < 0 || ny > 3;
    }

    private static void remove(int idx, int color) {
        for (int i = 0; i < 4; i++) {
            if (area[idx][i][color] != 0) {
                blockCount--;
                area[idx][i][color] = 0;
            }
        }
    }

    private static void sendBlock(int t, int x, int y) {
        if (t == 1) {
            int bIdx = y + 1;
            while (bIdx < 10 && area[bIdx][x][0] == 0) bIdx++;
            area[bIdx - 1][x][0] = blockNum;

            int gIdx = x + 1;
            while (gIdx < 10 && area[gIdx][y][1] == 0) gIdx++;
            area[gIdx - 1][y][1] = blockNum++;

            blockCount += 2;
        } else if (t == 2) {
            int bIdx = y + 2;
            while (bIdx < 10 && area[bIdx][x][0] == 0) bIdx++;
            area[bIdx - 1][x][0] = blockNum;
            area[bIdx - 2][x][0] = blockNum;

            int gIdx = x + 1;
            while (gIdx < 10 && (area[gIdx][y][1] == 0 && area[gIdx][y + 1][1] == 0)) gIdx++;
            area[gIdx - 1][y][1] = blockNum;
            area[gIdx - 1][y+1][1] = blockNum++;

            blockCount += 4;
        } else if (t == 3) {
            int bIdx = y + 1;
            while (bIdx < 10 && (area[bIdx][x][0] == 0 && area[bIdx][x + 1][0] == 0)) bIdx++;
            area[bIdx - 1][x][0] = blockNum;
            area[bIdx - 1][x + 1][0] = blockNum;

            int gIdx = x + 2;
            while (gIdx < 10 && area[gIdx][y][1] == 0) gIdx++;
            area[gIdx - 1][y][1] = blockNum;
            area[gIdx - 2][y][1] = blockNum++;

            blockCount += 4;
        }
    }
}
