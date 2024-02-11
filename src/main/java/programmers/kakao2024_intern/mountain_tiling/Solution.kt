package programmers.kakao2024_intern.mountain_tiling

class Solution {

    fun solution(n: Int, tops: IntArray): Int {
        val a = IntArray(n); val b = IntArray(n)
        a[0] = 1; b[0] = if (tops[0] == 1) 3 else 2
        for (k in 1 until n) {
            a[k] = (a[k - 1] + b[k - 1]) % 10007
            if (tops[k] == 1) b[k] = (2 * a[k - 1] + 3 * b[k - 1]) % 10007
            else b[k] = (a[k - 1] + 2 * b[k - 1]) % 10007
        }
        return (a[n - 1] + b[n - 1]) % 10007
    }

}