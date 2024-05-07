package programmers.hyundai_mobis_2023.air_conditioner

class Solution {

    fun solution(temperature: Int, t1: Int, t2: Int, a: Int, b: Int, onboard: IntArray): Int {
        val initTemp = temperature + 10; val r1 = t1 + 10; val r2 = t2 + 10
        val n = onboard.size
        val dp = Array<IntArray>(n + 1) { IntArray(51) { Int.MAX_VALUE } }
        dp[0][initTemp] = 0
        for (time in 0 until n) {
            for (temp in 0 .. 50) {
                if (dp[time][temp] == Int.MAX_VALUE) continue
                if (onboard[time] == 1 && (temp < r1 || temp > r2)) continue

                if (temp > 0) dp[time + 1][temp - 1] = Math.min(dp[time + 1][temp - 1], dp[time][temp] + a)
                if (temp < 50) dp[time + 1][temp + 1] = Math.min(dp[time + 1][temp + 1], dp[time][temp] + a)
                dp[time + 1][temp] = Math.min(dp[time + 1][temp], dp[time][temp] + b)

                var nextTemp = temp
                if (temp > initTemp) nextTemp--
                else if (temp < initTemp) nextTemp++
                dp[time + 1][nextTemp] = Math.min(dp[time + 1][nextTemp], dp[time][temp])
            }
        }

        var answer = Int.MAX_VALUE
        for (temp in 0 .. 50) {
            if (onboard[n - 1] == 1 && (temp < r1 || temp > r2)) continue
            answer = Math.min(answer, dp[n - 1][temp])
        }
        return answer
    }

}