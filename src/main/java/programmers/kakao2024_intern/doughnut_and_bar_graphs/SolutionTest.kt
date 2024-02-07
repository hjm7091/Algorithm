package programmers.kakao2024_intern.doughnut_and_bar_graphs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val edges = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(4, 3),
            intArrayOf(1, 1),
            intArrayOf(2, 1)
        )
        assertThat(solution.solution(edges)).isEqualTo(intArrayOf(2, 1, 1, 0))
    }

    @Test
    fun test2() {
        val edges = arrayOf(
            intArrayOf(4, 11), intArrayOf(1, 12), intArrayOf(8, 3),
            intArrayOf(12, 7), intArrayOf(4, 2), intArrayOf(7, 11),
            intArrayOf(4, 8), intArrayOf(9, 6), intArrayOf(10, 11),
            intArrayOf(6, 10), intArrayOf(3, 5), intArrayOf(11, 1),
            intArrayOf(5, 3), intArrayOf(11, 9), intArrayOf(3, 8)
        )
        assertThat(solution.solution(edges)).isEqualTo(intArrayOf(4, 0, 1, 2))
    }

    @Test
    fun test3() {
        val edges = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(4, 3),
            intArrayOf(1, 1),
            intArrayOf(2, 1)
        )
        assertThat(solution.solution(edges)).isEqualTo(intArrayOf(2, 1, 1, 0))
    }

    @Test
    fun test4() {
        val edges = arrayOf(
            intArrayOf(4, 1), intArrayOf(1, 12), intArrayOf(8, 3),
            intArrayOf(12, 7), intArrayOf(4, 2), intArrayOf(7, 11),
            intArrayOf(4, 5), intArrayOf(9, 6), intArrayOf(10, 11),
            intArrayOf(6, 10), intArrayOf(3, 5), intArrayOf(11, 1),
            intArrayOf(5, 3), intArrayOf(11, 9), intArrayOf(3, 8)
        )
        assertThat(solution.solution(edges)).isEqualTo(intArrayOf(4, 0, 1, 2))
    }

}