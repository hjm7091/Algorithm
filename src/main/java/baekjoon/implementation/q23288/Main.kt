package baekjoon.implementation.q23288

import java.util.LinkedList
import java.util.Scanner

class Point(val x: Int, val y: Int)

class Dice {
    val surfaces = Array(4) { IntArray(3) }
    init {
        surfaces[0][1] = 2
        surfaces[1][0] = 4; surfaces[1][1] = 1; surfaces[1][2] = 3
        surfaces[2][1] = 5
        surfaces[3][1] = 6
    }

    fun rollTo(way: Int) {
        when (way) {
            0 -> {
                val tmp = surfaces[0][1]
                surfaces[0][1] = surfaces[1][1]
                surfaces[1][1] = surfaces[2][1]
                surfaces[2][1] = surfaces[3][1]
                surfaces[3][1] = tmp
            }
            1 -> {
                val tmp = surfaces[3][1]
                surfaces[3][1] = surfaces[1][2]
                surfaces[1][2] = surfaces[1][1]
                surfaces[1][1] = surfaces[1][0]
                surfaces[1][0] = tmp
            }
            2 -> {
                val tmp = surfaces[3][1]
                surfaces[3][1] = surfaces[2][1]
                surfaces[2][1] = surfaces[1][1]
                surfaces[1][1] = surfaces[0][1]
                surfaces[0][1] = tmp
            }
            3 -> {
                val tmp = surfaces[3][1]
                surfaces[3][1] = surfaces[1][0]
                surfaces[1][0] = surfaces[1][1]
                surfaces[1][1] = surfaces[1][2]
                surfaces[1][2] = tmp
            }
            else -> throw IllegalArgumentException("$way is not allowed.")
        }
    }
}

class Map(val n: Int, val m: Int, val k: Int) {
    val dx = intArrayOf(-1, 0, 1, 0); val dy = intArrayOf(0, 1, 0, -1)
    val map = Array(n) { IntArray(m) }
    var score = 0

    fun initWith(sc: Scanner): Map {
        for (r in 0 until n) {
            for (c in 0 until m) {
                map[r][c] = sc.nextInt()
            }
        }
        return this
    }

    fun rollDice(): Map {
        val dice = Dice(); var dicePos = Point(0, 0); var way = 1
        repeat(k) {
            var nx = dicePos.x + dx[way]; var ny = dicePos.y + dy[way]
            if (nx !in 0 until n || ny !in 0 until m) {
                way = (way + 2) % 4
                nx = dicePos.x + dx[way]; ny = dicePos.y + dy[way]
            }
            dicePos = Point(nx, ny)
            score += calScoreFrom(dicePos)
            dice.rollTo(way)
            val diceBottom = dice.surfaces[3][1]
            if (diceBottom > map[dicePos.x][dicePos.y]) {
                way = (way + 1) % 4
            } else if (diceBottom < map[dicePos.x][dicePos.y]) {
                way = (way + 3) % 4
            }
        }
        return this
    }

    private fun calScoreFrom(p: Point): Int {
        var cnt = 1
        val visit = Array(n) { BooleanArray(m) }
        visit[p.x][p.y] = true
        val q = LinkedList<Point>()
        q.offer(p)
        while (q.isNotEmpty()) {
            val curr = q.poll()
            for (dir in 0 .. 3) {
                val nx = curr.x + dx[dir]; val ny = curr.y + dy[dir]
                if (nx !in 0 until n || ny !in 0 until m) continue
                if (visit[nx][ny]) continue
                if (map[nx][ny] == map[p.x][p.y]) {
                    visit[nx][ny] = true
                    q.offer(Point(nx, ny))
                    cnt++
                }
            }
        }
        return cnt * map[p.x][p.y]
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val map = Map(sc.nextInt(), sc.nextInt(), sc.nextInt())
        .initWith(sc)
        .rollDice()
    println(map.score)
}