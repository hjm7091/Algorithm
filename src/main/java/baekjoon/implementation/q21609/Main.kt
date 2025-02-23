package baekjoon.implementation.q21609

import java.util.*
import kotlin.math.pow

data class Block(val x: Int, val y: Int, val value: Int)

class Group(val blocks: List<Block>) {
    val rainbowCount = blocks.count { it.value == 0 }
    val criteriaBlock = if (blocks.isNotEmpty()) blocks.filter { it.value != 0 }.sortedWith(compareBy(Block::x, Block::y))[0] else null
}

class Board(val N: Int, val M: Int) {
    private val empty = 99
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var board = Array(N) { IntArray(N) { empty } }
    var score = 0

    fun init(sc: Scanner): Board {
        for (i in 0 until N) {
            for (j in 0 until N) {
                board[i][j] = sc.nextInt()
            }
        }
        return this
    }

    fun playGame(): Board {
        while (true) {
            val maxSizeGroup = findMaxSizeGroup()
            if (maxSizeGroup.blocks.size < 2) return this
            score += maxSizeGroup.blocks.size.toDouble().pow(2.0).toInt()
            maxSizeGroup.blocks.forEach { board[it.x][it.y] = empty }
            applyGravity(); rotateBoard(); applyGravity()
        }
    }

    fun print() {
        for (row in board) println(row.joinToString())
        println()
    }

    private fun applyGravity() {
        for (i in N - 2 downTo 0) {
            for (j in N - 1 downTo 0) {
                val num = board[i][j]
                if (num in 0 .. M) {
                    var k = i + 1
                    while (k < N && board[k][j] == empty) k++
                    val tmp = board[k - 1][j]
                    board[k - 1][j] = num
                    board[i][j] = tmp
                }
            }
        }
    }

    private fun rotateBoard() {
        val rotated = Array(N) { IntArray(N) { 0 } }
        for (i in 0 until N) {
            for (j in 0 until N) {
                rotated[N - j - 1][i] = board[i][j]
            }
        }
        board = rotated
    }

    private fun findMaxSizeGroup(): Group {
        val groups = mutableListOf<Group>()
        for (i in 0 until N) {
            for (j in 0 until N) {
                val num = board[i][j]
                if (num == 0 || num == -1 || num == empty) continue
                val blocks = getGroupBlocksFrom(Block(i, j, board[i][j]))
                groups += Group(blocks)
            }
        }
        if (groups.isEmpty()) return Group(emptyList())
        return groups.sortedWith(
            compareByDescending<Group> { it.blocks.size }
                .thenByDescending { it.rainbowCount }
                .thenByDescending { it.criteriaBlock!!.x }
                .thenByDescending { it.criteriaBlock!!.y }
        )[0]
    }

    private fun getGroupBlocksFrom(start: Block): List<Block> {
        val visit = Array(N) { BooleanArray(N) { false } }
        val q = LinkedList<Block>()
        q.offer(start)
        visit[start.x][start.y] = true
        val groupNum = board[start.x][start.y]
        val blocks = mutableListOf(start)
        while (q.isNotEmpty()) {
            val curr = q.poll()
            for (dir in 0 until 4) {
                val nx = curr.x + dx[dir]; val ny = curr.y + dy[dir]
                if (nx !in 0 until N || ny !in 0 until N) continue
                if (visit[nx][ny]) continue
                val nextNum = board[nx][ny]
                if (nextNum == -1 || (nextNum != 0 && nextNum != groupNum)) continue
                val next = Block(nx, ny, nextNum)
                q.offer(next)
                visit[next.x][next.y] = true
                blocks += next
            }
        }
        return blocks
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt(); val M = sc.nextInt()
    println(Board(N, M).init(sc).playGame().score)
}