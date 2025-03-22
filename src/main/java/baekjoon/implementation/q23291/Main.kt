package baekjoon.implementation.q23291

import java.util.Scanner
import kotlin.math.abs

val Empty = Node(0, size = 0)

class Node(val value: Int, var next: Node? = null, var size: Int = 1) {
    fun toArray(): IntArray {
        val arr = IntArray(size)
        arr[0] = value
        var curr = this.next
        for (i in 1 until size) {
            arr[i] = curr!!.value
            curr = curr.next
        }
        return arr
    }

    fun appendTail(newValue: Int) {
        var curr = this; size++
        while (curr.next != null) {
            curr = curr.next!!
            curr.size++
        }
        curr.next = Node(newValue)
    }
}

class FishBowl(val n: Int, val k: Int) {
    private val dx = intArrayOf(0, 0, -1, 1); private val dy = intArrayOf(1, -1, 0, 0)
    val map = Array(n) { IntArray(n) }
    var arrangeCount = 0

    fun initWith(sc: Scanner): FishBowl {
        for (i in 0 until n) {
            map[n - 1][i] = sc.nextInt()
        }
        return this
    }

    fun arrange(): FishBowl {
        while (!meetTheEndCondition()) {
            process1()
            process2()
            process3()
            process4()
            process5()
            process3()
            process4()
            arrangeCount++
        }
        return this
    }

    private fun process1() {
        val min = map[n - 1].min()
        map[n - 1].forEachIndexed { i, v -> if (min == v) map[n - 1][i]++ }
    }

    private fun process2() {
        val nodes = Array(n) { i -> Node(map[n - 1][i]) }
        nodes[1].next = Node(nodes[0].value)
        nodes[1].size++
        nodes[0] = Empty

        while (true) {
            var l = -1; var r = -1
            for (i in 0 until n) {
                if (nodes[i].size < 2) continue
                if (l == -1) l = i else r = i
            }
            if (l != -1 && r == -1) r = l
            val remainSize = (n - 1) - r
            if (remainSize < nodes[r].size) break
            val appendStartIdx = r + 1
            repeat((r - l) + 1) {
                val arr = nodes[r].toArray()
                var idx = appendStartIdx
                for (e in arr) {
                    nodes[idx].appendTail(e)
                    idx++
                }
                nodes[r--] = Empty
            }
        }

        for (i in 0 until n) {
            if (nodes[i].size == 0) {
                for (x in 0 until n) map[x][i] = 0
            } else {
                val arr = nodes[i].toArray()
                var x = n - 1
                for (j in arr.indices) {
                    map[x--][i] = arr[j]
                }
            }
        }
    }

    private fun process3() {
        val temp = Array(n) { IntArray(n) }
        val visit = Array(n) { BooleanArray(n) }
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (map[x][y] == 0) continue
                for (dir in 0 .. 3) {
                    val nx = x + dx[dir]; val ny = y + dy[dir]
                    if (nx !in 0 until n || ny !in 0 until n) continue
                    if (map[nx][ny] == 0 || visit[nx][ny]) continue
                    val diff = abs(map[x][y] - map[nx][ny])
                    val d = diff / 5
                    if (d > 0) {
                        if (map[x][y] > map[nx][ny]) {
                            temp[x][y] += -d; temp[nx][ny] += d
                        } else if (map[x][y] < map[nx][ny]) {
                            temp[x][y] += d; temp[nx][ny] += -d
                        }
                    }
                }
                visit[x][y] = true
            }
        }
        for (x in 0 until n) {
            for (y in 0 until n) {
                map[x][y] += temp[x][y]
            }
        }
    }

    private fun process4() {
        val temp = IntArray(n)
        var idx = 0
        for (y in 0 until n) {
            for (x in n - 1 downTo 0) {
                if (map[x][y] == 0) break
                temp[idx++] = map[x][y]
                map[x][y] = 0
            }
        }
        temp.forEachIndexed { i, v -> map[n - 1][i] = v }
    }

    private fun process5() {
        val nodes = Array(n) { i -> Node(map[n - 1][i]) }

        var p = n / 2
        repeat(2) {
            var i = p - 1; var j = p
            while (i in 0 until n && j in 0 until n) {
                for (e in nodes[i].toArray().reversed()) {
                    nodes[j].appendTail(e)
                }
                nodes[i] = Empty
                i--; j++
            }
            p += (p / 2)
        }

        for (i in 0 until n) {
            if (nodes[i].size == 0) {
                for (x in 0 until n) map[x][i] = 0
            } else {
                val arr = nodes[i].toArray()
                var x = n - 1
                for (j in arr.indices) {
                    map[x--][i] = arr[j]
                }
            }
        }
    }

    private fun meetTheEndCondition(): Boolean {
        val max = map[n - 1].max()
        val min = map[n - 1].min()
        return max - min <= k
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val fishBowl = FishBowl(sc.nextInt(), sc.nextInt()).initWith(sc).arrange()
    println(fishBowl.arrangeCount)
}