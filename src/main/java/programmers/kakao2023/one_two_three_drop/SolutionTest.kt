package programmers.kakao2023.one_two_three_drop

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val edges = arrayOf(
            intArrayOf(2, 4), intArrayOf(1, 2), intArrayOf(6, 8), intArrayOf(1, 3),
            intArrayOf(5, 7), intArrayOf(2, 5), intArrayOf(3, 6), intArrayOf(6, 10),
            intArrayOf(6, 9)
        )
        val target = intArrayOf(0, 0, 0, 3, 0, 0, 5, 1, 2, 3)
        Assertions.assertThat(solution.solution(edges, target)).isEqualTo(intArrayOf(1, 1, 2, 2, 2, 3, 3))
    }

    @Test
    fun test2() {
        val edges = arrayOf(
            intArrayOf(1, 2), intArrayOf(1, 3)
        )
        val target = intArrayOf(0, 7, 3)
        Assertions.assertThat(solution.solution(edges, target)).isEqualTo(intArrayOf(1, 1, 3, 2, 3))
    }

    @Test
    fun test3() {
        val edges = arrayOf(
            intArrayOf(1, 3), intArrayOf(1, 2)
        )
        val target = intArrayOf(0, 7, 1)
        Assertions.assertThat(solution.solution(edges, target)).isEqualTo(intArrayOf(-1))
    }

    @Test
    fun test4() {
        val edges = arrayOf(
            intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4),
            intArrayOf(2, 5), intArrayOf(3, 6)
        )
        val target = intArrayOf(0, 0, 0, 3, 0, 3)
        Assertions.assertThat(solution.solution(edges, target)).isEqualTo(intArrayOf(3, 3))
    }

}