package Baekjoon.Simulation.q19238;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class InfoToDestination {
    int passengerNum, distance;
    Position pos;

    public InfoToDestination(int passengerNum, int distance, Position pos) {
        this.passengerNum = passengerNum;
        this.distance = distance;
        this.pos = pos;
    }
}

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Main {

    static int N, M, fuel;
    static int[][] map;
    static Position taxi;
    static Position[] sources, destinations;
    static boolean[] arrived;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean impossible = false;

    public static void main(String[] args) {
        init();

        while (!allArrived() && fuel > 0) {
            InfoToDestination infoToPassenger = findNearestPassenger();

            if (infoToPassenger.distance == -1) {
                impossible = true;
                break;
            }

            fuel -= infoToPassenger.distance;
            taxi = infoToPassenger.pos;

//            printDebugMessage("completed move to passenger");

            InfoToDestination infoToDestination = calDistanceSrctoDst(infoToPassenger);

            if (infoToDestination.distance == -1) {
                impossible = true;
                break;
            }

            fuel -= infoToDestination.distance;
            taxi = infoToDestination.pos;

//            printDebugMessage("completed move to destination");

            arrived[infoToDestination.passengerNum] = true;
            fuel += infoToDestination.distance * 2;

//            printDebugMessage("completed refuel");
        }

        if (impossible)
            System.out.println(-1);
        else
            System.out.println(fuel);
    }

    private static void printDebugMessage(String message) {
        System.out.println("======" + message + "======");
        System.out.println("remain fuel : " + fuel + ", taxi : " + taxi);
        System.out.println();
    }

    private static InfoToDestination calDistanceSrctoDst(InfoToDestination infoToPassenger) {
        int[][] tmpMap = deepCopy(map);
        fill(tmpMap, -1);

        Position src = sources[infoToPassenger.passengerNum];
        Position dst = destinations[infoToPassenger.passengerNum];

        bfs(tmpMap, src);

        int distance = tmpMap[dst.x][dst.y];

        if (fuel - distance < 0) {
            fuel -= distance;
            return new InfoToDestination(infoToPassenger.passengerNum, -1, null);
        }

        return new InfoToDestination(infoToPassenger.passengerNum, distance, dst);
    }

    private static InfoToDestination findNearestPassenger() {
        int[][] tmpMap = deepCopy(map);
        fill(tmpMap, -1);
        bfs(tmpMap, taxi);
//        printMap(tmpMap);

        int minIdx = -1;
        Position minPos = null;
        int minDis = -1;

        boolean flag = false;

        for (int i = 1; i <= M; i++) {
            if (arrived[i]) //�̹� �Ϸ��� �°��� ���
                continue;

            if (tmpMap[sources[i].x][sources[i].y] == -1) //���� �Ұ����� �°��� ���
                continue;

            if (!flag) {
                minIdx = i;
                minPos = sources[minIdx];
                minDis = tmpMap[minPos.x][minPos.y];
                flag = true;
            } else {
                Position nowPos = sources[i];
                int nowDis = tmpMap[nowPos.x][nowPos.y];
                if (nowDis < minDis) {
                    minIdx = i;
                    minPos = nowPos;
                    minDis = nowDis;
                } else if (nowDis == minDis) {
                    if (nowPos.x < minPos.x) {
                        minIdx = i;
                        minPos = nowPos;
                        minDis = nowDis;
                    } else if (nowPos.x == minPos.x) {
                        if (nowPos.y < minPos.y) {
                            minIdx = i;
                            minPos = nowPos;
                            minDis = nowDis;
                        }
                    }
                }
            }
        }

        if (fuel - minDis < 0) {
            fuel -= minDis;
            return new InfoToDestination(minIdx, -1, null);
        }

        return new InfoToDestination(minIdx, minDis, minPos);
    }

    private static void fill(int[][] tmpMap, int i) {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (tmpMap[x][y] == 0)
                    tmpMap[x][y] = i;
            }
        }
    }

    private static void bfs(int[][] tmpMap, Position start) {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        q.add(start);
        visited[start.x][start.y] = true;
        tmpMap[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Position now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (rangeOver(nx, ny) || visited[nx][ny] || map[nx][ny] == 1)
                    continue;

                visited[nx][ny] = true;
                tmpMap[nx][ny] = tmpMap[now.x][now.y] + 1;
                q.add(new Position(nx, ny));
            }
        }
    }

    private static boolean rangeOver(int nx, int ny) {
        return nx < 1 || nx > N || ny < 1 || ny > N;
    }

    private static int[][] deepCopy(int[][] map) {
        int[][] copy = new int[N+1][N+1];

        for (int x = 1; x <= N; x++)
            for (int y = 1; y <= N; y++)
                copy[x][y] = map[x][y];

        return copy;
    }

    private static boolean allArrived() {
        for (int i = 1; i <= M; i++) {
            if (!arrived[i])
                return false;
        }
        return true;
    }

    private static void printMap(int[][] map) {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        fuel = input.nextInt();
        map = new int[N+1][N+1];
        sources = new Position[M+1];
        destinations = new Position[M+1];
        arrived = new boolean[M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = input.nextInt();
            }
        }

        taxi = new Position(input.nextInt(), input.nextInt());

        for (int i = 1; i <= M; i++) {
            int srcX = input.nextInt(); int srcY = input.nextInt();
            int dstX = input.nextInt(); int dstY = input.nextInt();
            sources[i] = new Position(srcX, srcY);
            destinations[i] = new Position(dstX, dstY);
        }

        input.close();
    }

}
