package programmers.hyundai_mobis_2023.number_of_counselors

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun case1() {
        val k = 3
        val n = 5
        val reqs = arrayOf(
            intArrayOf(10, 60, 1), intArrayOf(15, 100, 3), intArrayOf(20, 30, 1),
            intArrayOf(30, 50, 3), intArrayOf(50, 40, 1), intArrayOf(60, 30, 2),
            intArrayOf(65, 30, 1), intArrayOf(70, 100, 2)
        )
        val expected = 25
        val actual = solution.solution(k, n, reqs)
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun case2() {
        val k = 2
        val n = 3
        val reqs = arrayOf(
            intArrayOf(5, 55, 2), intArrayOf(10, 90, 2), intArrayOf(20, 40, 2),
            intArrayOf(50, 45, 2), intArrayOf(100, 50, 2)
        )
        val expected = 90
        val actual = solution.solution(k, n, reqs)
        assertThat(actual).isEqualTo(expected)
    }

}