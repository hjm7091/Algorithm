package baekjoon.implementation.q23289

import java.util.LinkedList
import java.util.Scanner

data class Point(val x: Int, val y: Int, var value: Int = 0) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as Point
        return this.x == other.x && this.y == other.y
    }
    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

data class Wall(val from: Point, val to: Point) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as Wall
        return (this.from == other.from && this.to == other.to) || (this.from == other.to && this.to == other.from)
    }
    override fun hashCode(): Int {
        val points = listOf(from, to).sortedBy { it.hashCode() }
        return points[0].hashCode() * 31 + points[1].hashCode()
    }
}

class House {
    private val dx = intArrayOf(0, 0, -1, 1); private val dy = intArrayOf(1, -1, 0, 0)
    private var r = 0; private var c = 0; private var k = 0
    private lateinit var board: Array<IntArray>
    private val heaterPoints = mutableListOf<Point>()
    private val tempCheckReqPoints = mutableListOf<Point>()
    private val walls = mutableSetOf<Wall>()
    var chocolateCount = 0

    fun init(sc: Scanner): House {
        r = sc.nextInt(); c = sc.nextInt(); k = sc.nextInt()
        board = Array(r) { IntArray(c) }
        for (i in 0 until r) {
            for (j in 0 until c) {
                val value = sc.nextInt()
                if (value in 1 .. 4) heaterPoints += Point(i, j, value)
                if (value == 5) tempCheckReqPoints += Point(i, j)
            }
        }
        val w = sc.nextInt()
        repeat(w) {
            val from = Point(sc.nextInt() - 1, sc.nextInt() - 1)
            val way = sc.nextInt()
            walls += Wall(from, if (way == 1) Point(from.x, from.y + 1) else Point(from.x - 1, from.y))
        }
        return this
    }

    fun testPerformance(): House {
        while (!meetTheEndCondition()) {
            runHeaters()
            adjustTemperature()
            decreaseTemperature()
            chocolateCount++
            if (chocolateCount > 100) break
        }
        return this
    }

    private fun runHeaters() {
        for (hp in heaterPoints) {
            val dir = hp.value - 1
            val visit = Array(r) { BooleanArray(c) }
            val q = LinkedList<Point>()
            val init = Point(hp.x + dx[dir], hp.y + dy[dir], 5)
            board[init.x][init.y] += init.value
            visit[init.x][init.y] = true
            q.offer(init)
            while (q.isNotEmpty()) {
                val curr = q.poll()
                val next = Point(curr.x + dx[dir], curr.y + dy[dir], curr.value - 1)
                if (next.value < 1) continue
                if (inRange(next) && !visit[next.x][next.y] && Wall(curr, next) !in walls) {
                    board[next.x][next.y] += next.value; visit[next.x][next.y] = true; q.offer(next)
                }
                if (dir == 0) {
                    val nextUp = Point(next.x - 1, next.y, next.value)
                    val nextUpLeft = Point(nextUp.x, nextUp.y - 1)
                    val nextDown = Point(next.x + 1, next.y, next.value)
                    val nextDownLeft = Point(nextDown.x, nextDown.y - 1)
                    if (inRange(nextUp) && !visit[nextUp.x][nextUp.y] && Wall(curr, nextUpLeft) !in walls && Wall(nextUpLeft, nextUp) !in walls) {
                        board[nextUp.x][nextUp.y] += nextUp.value; visit[nextUp.x][nextUp.y] = true; q.offer(nextUp)
                    }
                    if (inRange(nextDown) && !visit[nextDown.x][nextDown.y] && Wall(curr, nextDownLeft) !in walls && Wall(nextDownLeft, nextDown) !in walls) {
                        board[nextDown.x][nextDown.y] += nextDown.value; visit[nextDown.x][nextDown.y] = true; q.offer(nextDown)
                    }
                }
                if (dir == 1) {
                    val nextUp = Point(next.x - 1, next.y, next.value)
                    val nextUpRight = Point(nextUp.x, nextUp.y + 1)
                    val nextDown = Point(next.x + 1, next.y, next.value)
                    val nextDownRight = Point(nextDown.x, nextDown.y + 1)
                    if (inRange(nextUp) && !visit[nextUp.x][nextUp.y] && Wall(curr, nextUpRight) !in walls && Wall(nextUpRight, nextUp) !in walls) {
                        board[nextUp.x][nextUp.y] += nextUp.value; visit[nextUp.x][nextUp.y] = true; q.offer(nextUp)
                    }
                    if (inRange(nextDown) && !visit[nextDown.x][nextDown.y] && Wall(curr, nextDownRight) !in walls && Wall(nextDownRight, nextDown) !in walls) {
                        board[nextDown.x][nextDown.y] += nextDown.value; visit[nextDown.x][nextDown.y] = true; q.offer(nextDown)
                    }
                }
                if (dir == 2) {
                    val nextLeft = Point(next.x, next.y - 1, next.value)
                    val nextLeftDown = Point(nextLeft.x + 1, nextLeft.y)
                    val nextRight = Point(next.x, next.y + 1, next.value)
                    val nextRightDown = Point(nextRight.x + 1, nextRight.y)
                    if (inRange(nextLeft) && !visit[nextLeft.x][nextLeft.y] && Wall(curr, nextLeftDown) !in walls && Wall(nextLeftDown, nextLeft) !in walls) {
                        board[nextLeft.x][nextLeft.y] += nextLeft.value; visit[nextLeft.x][nextLeft.y] = true; q.offer(nextLeft)
                    }
                    if (inRange(nextRight) && !visit[nextRight.x][nextRight.y] && Wall(curr, nextRightDown) !in walls && Wall(nextRightDown, nextRight) !in walls) {
                        board[nextRight.x][nextRight.y] += nextRight.value; visit[nextRight.x][nextRight.y] = true; q.offer(nextRight)
                    }
                }
                if (dir == 3) {
                    val nextLeft = Point(next.x, next.y - 1, next.value)
                    val nextLeftUp = Point(nextLeft.x - 1, nextLeft.y)
                    val nextRight = Point(next.x, next.y + 1, next.value)
                    val nextRightUp = Point(nextRight.x - 1, nextRight.y)
                    if (inRange(nextLeft) && !visit[nextLeft.x][nextLeft.y] && Wall(curr, nextLeftUp) !in walls && Wall(nextLeftUp, nextLeft) !in walls) {
                        board[nextLeft.x][nextLeft.y] += nextLeft.value; visit[nextLeft.x][nextLeft.y] = true; q.offer(nextLeft)
                    }
                    if (inRange(nextRight) && !visit[nextRight.x][nextRight.y] && Wall(curr, nextRightUp) !in walls && Wall(nextRightUp, nextRight) !in walls) {
                        board[nextRight.x][nextRight.y] += nextRight.value; visit[nextRight.x][nextRight.y] = true; q.offer(nextRight)
                    }
                }
            }
        }
    }

    private fun adjustTemperature() {
        val temp = Array(r) { IntArray(c) }
        for (x in 0 until r) {
            for (y in 0 until c) {
                for (dir in 0 .. 3) {
                    val curr = Point(x, y)
                    val next = Point(x + dx[dir], y + dy[dir])
                    if (!inRange(next)) continue
                    if (Wall(curr, next) in walls) continue
                    val diff = board[x][y] - board[next.x][next.y]
                    if (diff <= 0) continue
                    temp[curr.x][curr.y] -= (diff / 4)
                    temp[next.x][next.y] += (diff / 4)
                }
            }
        }
        for (x in 0 until r) {
            for (y in 0 until c) {
                board[x][y] += temp[x][y]
            }
        }
    }

    private fun decreaseTemperature() {
        for (y in 0 until c) {
            if (board[0][y] > 0) board[0][y]--
            if (board[r - 1][y] > 0) board[r - 1][y]--
        }
        for (x in 1 until r - 1) {
            if (board[x][0] > 0) board[x][0]--
            if (board[x][c - 1] > 0) board[x][c - 1]--
        }
    }

    private fun meetTheEndCondition(): Boolean {
        return tempCheckReqPoints.all { board[it.x][it.y] >= k }
    }

    private fun inRange(p: Point): Boolean {
        return p.x in 0 until r && p.y in 0 until c
    }

}

fun main() {
    val house = House().init(Scanner(System.`in`)).testPerformance()
    println(house.chocolateCount)
}