package Baekjoon.Simulation.q19237;

import java.util.*;

class Trace {
    int sharkNum;
    int smell;

    public Trace(int sharkNum, int smell) {
        this.sharkNum = sharkNum;
        this.smell = smell;
    }

    public boolean isEmpty() {
        return this.sharkNum == 0;
    }

    @Override
    public String toString() {
        return "(" + sharkNum + ", " + smell + ")";
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x:" + x + ", y:" + y + ")";
    }
}

public class Main {

    static int N, M, K;
    static int[][][] priorityDir;
    static int[] sharkDir;
    static Pos[] sharkPos;
    static Trace[][] traces;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1};
    static int time = 0;

    public static void main(String[] args) {
        init();

//        printInfo("=========init=========");

        while (time < 1000) {
            scent();
//            printInfo("after scent, time : " + time);
            moveShark();
//            printInfo("after moveShark, time : " + time);

            time++;

            if (checkOnlyRemainSharkOne()) {
                System.out.println(time);
                System.exit(0);
            }

            minusSmell();
//            printInfo("after minusSmell, time : " + time);
        }

        System.out.println(-1);
    }

    private static void printInfo(String msg) {
        System.out.println(msg);
        System.out.println("sharkDir : " + Arrays.toString(sharkDir));
        System.out.println("sharkPos : " + Arrays.toString(sharkPos));
        System.out.println("=========Traces=========");
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(traces[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void init() {
        Scanner input = new Scanner(System.in);

        N = input.nextInt(); M = input.nextInt(); K = input.nextInt();

        priorityDir = new int[M+1][5][5]; //[x][y][z] x번째 상어의 방향이 y였을 경우의 우선 순위
        sharkDir = new int[M+1];
        sharkPos = new Pos[M+1];
        traces = new Trace[N][N];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int sharkNum = input.nextInt();
                if (sharkNum != 0)
                    sharkPos[sharkNum] = new Pos(x, y);
                traces[x][y] = new Trace(0, 0);
            }
        }

        for (int sharkNum = 1; sharkNum <= M; sharkNum++)
            sharkDir[sharkNum] = input.nextInt();

        for (int sharkNum = 1; sharkNum <= M; sharkNum++) {
            for (int sharkDir = 1; sharkDir <= 4; sharkDir++) {
                for (int dir = 1; dir <= 4; dir++) {
                    priorityDir[sharkNum][sharkDir][dir] = input.nextInt();
                }
            }
        }

        input.close();
    }

    private static void scent() {
        for (int sharkNum = 1; sharkNum <= M; sharkNum++) {
            Pos pos = sharkPos[sharkNum];
            if (pos != null) {
                traces[pos.x][pos.y].sharkNum = sharkNum;
                traces[pos.x][pos.y].smell = K;
            }
        }
    }

    private static void moveShark() {
        loop:
        for (int sharkNum = 1; sharkNum <= M; sharkNum++) {
            Pos nowSharkPos = sharkPos[sharkNum];
            int nowSharkDir = sharkDir[sharkNum];
            int[] nowSharkPriorities = priorityDir[sharkNum][nowSharkDir];
            if (nowSharkPos != null) {
                Pos[] emptySpaces = getEmptySpaces(nowSharkPos);
                Pos[] sameSmellSpaces = getSameSmellSpaces(sharkNum, nowSharkPos);

                for (int topPriorityDir : nowSharkPriorities) {
                    if (emptySpaces[topPriorityDir] != null) {
                        sharkDir[sharkNum] = topPriorityDir;
                        nowSharkPos.x = emptySpaces[topPriorityDir].x;
                        nowSharkPos.y = emptySpaces[topPriorityDir].y;
                        removeBiggerNumShark();
                        continue loop;
                    }
                }

                for (int topPriorityDir : nowSharkPriorities) {
                    if (sameSmellSpaces[topPriorityDir] != null) {
                        sharkDir[sharkNum] = topPriorityDir;
                        nowSharkPos.x = sameSmellSpaces[topPriorityDir].x;
                        nowSharkPos.y = sameSmellSpaces[topPriorityDir].y;
                        removeBiggerNumShark();
                        continue loop;
                    }
                }
            }
        }
    }

    private static void removeBiggerNumShark() {
        for (int sharkNum = 1; sharkNum < M; sharkNum++) {
            Pos criteriaPos = sharkPos[sharkNum];
            if (criteriaPos != null) {
                for (int comp = sharkNum + 1; comp <= M; comp++) {
                    Pos comparePos = sharkPos[comp];
                    if (comparePos != null) {
                        if (criteriaPos.x == comparePos.x && criteriaPos.y == comparePos.y) {
                            sharkPos[comp] = null;
                            sharkDir[comp] = 0;
                        }
                    }
                }
            }
        }
    }

    private static Pos[] getSameSmellSpaces(int sharkNum, Pos nowSharkPos) {
        Pos[] poses = new Pos[5];

        for (int dir = 1; dir <= 4; dir++) {
            int nx = nowSharkPos.x + dx[dir];
            int ny = nowSharkPos.y + dy[dir];
            if (rangeOver(nx, ny) || traces[nx][ny].isEmpty())
                continue;
            if (traces[nx][ny].sharkNum == sharkNum)
                poses[dir] = new Pos(nx, ny);
        }

        return poses;
    }

    private static Pos[] getEmptySpaces(Pos nowSharkPos) {
        Pos[] poses = new Pos[5];

        for (int dir = 1; dir <= 4; dir++) {
            int nx = nowSharkPos.x + dx[dir];
            int ny = nowSharkPos.y + dy[dir];
            if (rangeOver(nx, ny) || !traces[nx][ny].isEmpty())
                continue;
            poses[dir] = new Pos(nx, ny);
        }

        return poses;
    }

    private static boolean rangeOver(int nx, int ny) {
        return nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1;
    }

    private static void minusSmell() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!traces[x][y].isEmpty()) {
                    traces[x][y].smell--;

                    if (traces[x][y].smell == 0){
                        traces[x][y].sharkNum = 0;
                    }
                }
            }
        }
    }

    private static boolean checkOnlyRemainSharkOne() {
        for (int sharkNum = 2; sharkNum <= M; sharkNum++) {
            if (sharkPos[sharkNum] != null)
                return false;
        }
        return true;
    }
}
