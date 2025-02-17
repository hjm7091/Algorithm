package baekjoon.implementation.q21608

import java.util.Scanner
import kotlin.math.pow

data class Student(val num: Int, val likeStudents: MutableList<Int>)

class Board(val size: Int) {
    val board = Array(size) { IntArray(size) { -1 } }
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun findNextPosFor(student: Student): Pair<Int, Int> {
        val result1 = getPosMeetCondition1(student.likeStudents)
        if (result1.size == 1) return Pair(result1[0].first, result1[0].second)
        val result2 = getPosMeetCondition2(result1.map { Pair(it.first, it.second) })
        if (result2.size == 1) return Pair(result2[0].first, result2[0].second)
        return getPosMeetCondition3(result2.map { Pair(it.first, it.second) })
    }

    fun scoreSum(students: List<Student>): Int {
        var sum = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                val student = students.find { it.num == board[i][j] }!!
                var likeCount = 0
                for (dir in 0 .. 3) {
                    val nx = i + dx[dir]; val ny = j + dy[dir]
                    if (nx in 0 ..< size && ny in 0 ..< size && board[nx][ny] in student.likeStudents) {
                        likeCount++
                    }
                }
                sum += if (likeCount > 1) 10.0.pow((likeCount - 1).toDouble()).toInt() else likeCount
            }
        }
        return sum
    }

    private fun getPosMeetCondition1(likeStudents: List<Int>): List<Triple<Int, Int, Int>> {
        val triples = mutableListOf<Triple<Int, Int, Int>>()
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (board[i][j] != -1) continue
                var likeCount = 0
                for (dir in 0 .. 3) {
                    val nx = i + dx[dir]; val ny = j + dy[dir]
                    if (nx in 0 ..< size && ny in 0 ..< size && board[nx][ny] in likeStudents) {
                        likeCount++
                    }
                }
                triples += Triple(i, j, likeCount)
            }
        }

        val sorted = triples.sortedByDescending { it.third }
        val max = mutableListOf(sorted[0])
        for (i in 1 until sorted.size) if (max[0].third == sorted[i].third) max += sorted[i]
        return max
    }

    private fun getPosMeetCondition2(positions: List<Pair<Int, Int>>): List<Triple<Int, Int, Int>> {

        fun getAdjEmptyCountFrom(p: Pair<Int, Int>): Int {
            var count = 0
            for (i in 0 .. 3) {
                val nx = p.first + dx[i]; val ny = p.second + dy[i]
                if (nx in 0 ..< size && ny in 0 ..< size) {
                    if (board[nx][ny] == -1) count++
                }
            }
            return count
        }

        val triples = mutableListOf<Triple<Int, Int, Int>>()
        for (pos in positions) {
            triples += Triple(pos.first, pos.second, getAdjEmptyCountFrom(Pair(pos.first, pos.second)))
        }

        val sorted = triples.sortedByDescending { it.third }
        val max = mutableListOf(sorted[0])
        for (i in 1 until sorted.size) if (max[0].third == sorted[i].third) max += sorted[i]
        return max
    }

    private fun getPosMeetCondition3(positions: List<Pair<Int, Int>>): Pair<Int, Int> {
        return positions.sortedBy { it.second }.sortedBy { it.first }[0]
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val board = Board(N)
    val students = arrayListOf<Student>()
    repeat (N * N) {
        val student = Student(sc.nextInt(), mutableListOf())
        repeat(4) { student.likeStudents += sc.nextInt() }
        students += student
    }
    students.forEach {
        val nextPos = board.findNextPosFor(it)
        board.board[nextPos.first][nextPos.second] = it.num
    }
    println(board.scoreSum(students))
}