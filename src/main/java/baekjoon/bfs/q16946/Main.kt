package baekjoon.bfs.q16946

import java.util.LinkedList
import java.util.Scanner

data class Cell(val x: Int, val y: Int)

class Graph(val size: Int, val accessibleFrom: Set<Cell>)

class Map(val n: Int, val m: Int) {
    val map = Array(n) { IntArray(m) }
    val result = Array(n) { IntArray(m) }
    val visit = Array(n) { BooleanArray(m) }
    val graphs = mutableListOf<Graph>()
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun init(sc: Scanner): Map {
        for (i in 0 until n) {
            val line = sc.next()
            for (j in 0 until m) {
                map[i][j] = Character.getNumericValue(line[j])
            }
        }
        return this
    }

    fun record(): Map {
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    val (cnt, aroundCells) = countMovableCell(Cell(i, j))
                    graphs += Graph(cnt, aroundCells)
                }
            }
        }
        for (graph in graphs) {
            graph.accessibleFrom.forEach {
                result[it.x][it.y] += if (result[it.x][it.y] > 0) graph.size else graph.size + 1
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (map[i][j] == 1) {
                    result[i][j] = if (result[i][j] > 0) result[i][j] % 10 else 1
                }
            }
        }
        return this
    }

    private fun countMovableCell(start: Cell): Pair<Int, Set<Cell>> {
        var cnt = 1
        val aroundCells = mutableSetOf<Cell>()
        val q = LinkedList<Cell>()
        q.offer(start)
        visit[start.x][start.y] = true
        while (q.isNotEmpty()) {
            val curr = q.poll()
            for (dir in 0 until dx.size) {
                val next = Cell(curr.x + dx[dir], curr.y + dy[dir])
                if (next.x !in 0 until n || next.y !in 0 until m) continue
                if (visit[next.x][next.y]) continue
                if (map[next.x][next.y] != 0) {
                    aroundCells += next
                    continue
                }
                q.offer(next)
                visit[next.x][next.y] = true
                cnt++
            }
        }
        return Pair(cnt, aroundCells)
    }

    fun print() {
        for (i in 0 until n) println(result[i].joinToString(separator = ""))
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    Map(sc.nextInt(), sc.nextInt())
        .init(sc)
        .record()
        .print()
}

