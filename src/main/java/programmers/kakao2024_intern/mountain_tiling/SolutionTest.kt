package programmers.kakao2024_intern.mountain_tiling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val n = 4
        val tops = intArrayOf(1, 1, 0, 1)
        assertThat(solution.solution(n, tops)).isEqualTo(149)
    }

    @Test
    fun test2() {
        val n = 2
        val tops = intArrayOf(0, 1)
        assertThat(solution.solution(n, tops)).isEqualTo(11)
    }

    @Test
    fun test3() {
        val n = 10
        val tops = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        assertThat(solution.solution(n, tops)).isEqualTo(7704)
    }

}