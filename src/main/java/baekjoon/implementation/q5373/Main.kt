package baekjoon.implementation.q5373

import java.util.Scanner

class Cube {
    private val u = Array(3) { CharArray(3) { 'w' } }
    private val d = Array(3) { CharArray(3) { 'y' } }
    private val f = Array(3) { CharArray(3) { 'r' } }
    private val b = Array(3) { CharArray(3) { 'o' } }
    private val l = Array(3) { CharArray(3) { 'g' } }
    private val r = Array(3) { CharArray(3) { 'b' } }

    fun apply(ways: List<String>): Cube {
        for (way in ways) {
            val surface = way[0]
            val clockWay = way[1]
            when (surface) {
                'U' -> {
                    rotateSurface(clockWay, u)
                    if (clockWay == '-') rotateRowBetweenSurface(0, listOf(f, r, b, l))
                    if (clockWay == '+') rotateRowBetweenSurface(0, listOf(f, l, b, r))
                }
                'D' -> {
                    rotateSurface(clockWay, d)
                    if (clockWay == '-') rotateRowBetweenSurface(2, listOf(f, l, b, r))
                    if (clockWay == '+') rotateRowBetweenSurface(2, listOf(f, r, b, l))
                }
                'F' -> {
                    rotateSurface(clockWay, f)
                    if (clockWay == '-') {
                        var prev = charArrayOf(u[2][0], u[2][1], u[2][2])
                        var curr = charArrayOf(l[0][2], l[1][2], l[2][2])
                        l[0][2] = prev[2]; l[1][2] = prev[1]; l[2][2] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(d[0][0], d[0][1], d[0][2])
                        d[0][0] = prev[0]; d[0][1] = prev[1]; d[0][2] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(r[0][0], r[1][0], r[2][0])
                        r[0][0] = prev[2]; r[1][0] = prev[1]; r[2][0] = prev[0]
                        prev = curr.clone()
                        u[2][0] = prev[0]; u[2][1] = prev[1]; u[2][2] = prev[2]
                    }
                    if (clockWay == '+') {
                        var prev = charArrayOf(u[2][0], u[2][1], u[2][2])
                        var curr = charArrayOf(r[0][0], r[1][0], r[2][0])
                        r[0][0] = prev[0]; r[1][0] = prev[1]; r[2][0] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(d[0][0], d[0][1], d[0][2])
                        d[0][0] = prev[2]; d[0][1] = prev[1]; d[0][2] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(l[0][2], l[1][2], l[2][2])
                        l[0][2] = prev[0]; l[1][2] = prev[1]; l[2][2] = prev[2]
                        prev = curr.clone()
                        u[2][0] = prev[2]; u[2][1] = prev[1]; u[2][2] = prev[0]
                    }
                }
                'B' -> {
                    rotateSurface(clockWay, b)
                    if (clockWay == '-') {
                        var prev = charArrayOf(u[0][0], u[0][1], u[0][2])
                        var curr = charArrayOf(r[0][2], r[1][2], r[2][2])
                        r[0][2] = prev[0]; r[1][2] = prev[1]; r[2][2] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(d[2][0], d[2][1], d[2][2])
                        d[2][0] = prev[2]; d[2][1] = prev[1]; d[2][2] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(l[0][0], l[1][0], l[2][0])
                        l[0][0] = prev[0]; l[1][0] = prev[1]; l[2][0] = prev[2]
                        prev = curr.clone()
                        u[0][0] = prev[2]; u[0][1] = prev[1]; u[0][2] = prev[0]
                    }
                    if (clockWay == '+') {
                        var prev = charArrayOf(u[0][0], u[0][1], u[0][2])
                        var curr = charArrayOf(l[0][0], l[1][0], l[2][0])
                        l[0][0] = prev[2]; l[1][0] = prev[1]; l[2][0] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(d[2][0], d[2][1], d[2][2])
                        d[2][0] = prev[0]; d[2][1] = prev[1]; d[2][2] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(r[0][2], r[1][2], r[2][2])
                        r[0][2] = prev[2]; r[1][2] = prev[1]; r[2][2] = prev[0]
                        prev = curr.clone()
                        u[0][0] = prev[0]; u[0][1] = prev[1]; u[0][2] = prev[2]
                    }
                }
                'L' -> {
                    rotateSurface(clockWay, l)
                    if (clockWay == '-') {
                        var prev = charArrayOf(u[0][0], u[1][0], u[2][0])
                        var curr = charArrayOf(b[0][2], b[1][2], b[2][2])
                        b[0][2] = prev[2]; b[1][2] = prev[1]; b[2][2] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(d[0][0], d[1][0], d[2][0])
                        d[0][0] = prev[2]; d[1][0] = prev[1]; d[2][0] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(f[0][0], f[1][0], f[2][0])
                        f[0][0] = prev[0]; f[1][0] = prev[1]; f[2][0] = prev[2]
                        prev = curr.clone()
                        u[0][0] = prev[0]; u[1][0] = prev[1]; u[2][0] = prev[2]
                    }
                    if (clockWay == '+') {
                        var prev = charArrayOf(u[0][0], u[1][0], u[2][0])
                        var curr = charArrayOf(f[0][0], f[1][0], f[2][0])
                        f[0][0] = prev[0]; f[1][0] = prev[1]; f[2][0] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(d[0][0], d[1][0], d[2][0])
                        d[0][0] = prev[0]; d[1][0] = prev[1]; d[2][0] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(b[0][2], b[1][2], b[2][2])
                        b[0][2] = prev[2]; b[1][2] = prev[1]; b[2][2] = prev[0]
                        prev = curr.clone()
                        u[0][0] = prev[2]; u[1][0] = prev[1]; u[2][0] = prev[0]
                    }
                }
                'R' -> {
                    rotateSurface(clockWay, r)
                    if (clockWay == '-') {
                        var prev = charArrayOf(u[0][2], u[1][2], u[2][2])
                        var curr = charArrayOf(f[0][2], f[1][2], f[2][2])
                        f[0][2] = prev[0]; f[1][2] = prev[1]; f[2][2] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(d[0][2], d[1][2], d[2][2])
                        d[0][2] = prev[0]; d[1][2] = prev[1]; d[2][2] = prev[2]
                        prev = curr.clone()
                        curr = charArrayOf(b[0][0], b[1][0], b[2][0])
                        b[0][0] = prev[2]; b[1][0] = prev[1]; b[2][0] = prev[0]
                        prev = curr.clone()
                        u[0][2] = prev[2]; u[1][2] = prev[1]; u[2][2] = prev[0]
                    }
                    if (clockWay == '+') {
                        var prev = charArrayOf(u[0][2], u[1][2], u[2][2])
                        var curr = charArrayOf(b[0][0], b[1][0], b[2][0])
                        b[0][0] = prev[2]; b[1][0] = prev[1]; b[2][0] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(d[0][2], d[1][2], d[2][2])
                        d[0][2] = prev[2]; d[1][2] = prev[1]; d[2][2] = prev[0]
                        prev = curr.clone()
                        curr = charArrayOf(f[0][2], f[1][2], f[2][2])
                        f[0][2] = prev[0]; f[1][2] = prev[1]; f[2][2] = prev[2]
                        prev = curr.clone()
                        u[0][2] = prev[0]; u[1][2] = prev[1]; u[2][2] = prev[2]
                    }
                }
            }
//            println("after applying $way")
//            print("UP", u); print("DOWN", d); print("FRONT", f)
//            print("BACK", b); print("LEFT", l); print("RIGHT", r)
//            println("================================")
        }
        return this
    }

    private fun rotateRowBetweenSurface(num: Int, surfaces: List<Array<CharArray>>) {
        var prev = surfaces[0][num].clone()
        for (i in 1 until surfaces.size) {
            val curr = surfaces[i][num].clone()
            surfaces[i][num] = prev
            prev = curr
        }
        surfaces[0][num] = prev
    }

    private fun rotateSurface(clockWay: Char, s: Array<CharArray>) {
        if (clockWay == '-') {
            var prev = s[0][2]; var curr = s[0][0]
            s[0][0] = prev
            prev = curr; curr = s[2][0]
            s[2][0] = prev
            prev = curr; curr = s[2][2]
            s[2][2] = prev
            prev = curr; s[0][2] = prev

            prev = s[0][1]; curr = s[1][0]
            s[1][0] = prev
            prev = curr; curr = s[2][1]
            s[2][1] = prev
            prev = curr; curr = s[1][2]
            s[1][2] = prev
            prev = curr; s[0][1] = prev
        }
        if (clockWay == '+') {
            var prev = s[0][0]; var curr = s[0][2]
            s[0][2] = prev
            prev = curr; curr = s[2][2]
            s[2][2] = prev
            prev = curr; curr = s[2][0]
            s[2][0] = prev
            prev = curr; s[0][0] = prev

            prev = s[0][1]; curr = s[1][2]
            s[1][2] = prev
            prev = curr; curr = s[2][1]
            s[2][1] = prev
            prev = curr; curr = s[1][0]
            s[1][0] = prev
            prev = curr; s[0][1] = prev
        }
    }

    fun print(name: String, surface: Array<CharArray>) {
        println(name)
        for (row in surface) println(String(row))
        println()
    }

    fun printUp() {
        for (row in u) println(String(row))
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    var tcNum = sc.nextInt()
    while (tcNum-- > 0) {
        var n = sc.nextInt()
        val ways = mutableListOf<String>()
        while (n-- > 0) ways += sc.next()
        Cube().apply(ways)
            .printUp()
    }
}

