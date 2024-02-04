package programmers.kakao2024_intern.picking_the_dice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val dice = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(3, 3, 3, 3, 4, 4),
            intArrayOf(1, 3, 3, 4, 4, 4),
            intArrayOf(1, 1, 4, 4, 5, 5),
        )
        val expected = intArrayOf(1, 4)
        assertThat(solution.solution(dice)).isEqualTo(expected)
    }

    @Test
    fun test2() {
        val dice = arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(2, 2, 4, 4, 6, 6),
        )
        val expected = intArrayOf(2)
        assertThat(solution.solution(dice)).isEqualTo(expected)
    }

    @Test
    fun test3() {
        val dice = arrayOf(
            intArrayOf(40, 41, 42, 43, 44, 45),
            intArrayOf(43, 43, 42, 42, 41, 41),
            intArrayOf(1, 1, 80, 80, 80, 80),
            intArrayOf(70, 70, 1, 1, 70, 70),
        )
        val expected = intArrayOf(1, 3)
        assertThat(solution.solution(dice)).isEqualTo(expected)
    }

    @Test
    fun test4() {
        val dice = arrayOf(
            intArrayOf(40, 41, 42, 43, 44, 45),
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(3, 3, 3, 3, 4, 4),
            intArrayOf(1, 3, 3, 4, 4, 4),
            intArrayOf(1, 1, 4, 4, 5, 5),
            intArrayOf(43, 43, 42, 42, 41, 41),
            intArrayOf(1, 2, 3, 4, 5, 6),
            intArrayOf(70, 70, 1, 1, 70, 70),
            intArrayOf(2, 2, 4, 4, 6, 6),
            intArrayOf(1, 1, 80, 80, 80, 80),
        )
        val expected = intArrayOf(1, 2, 6, 8, 10)
        assertThat(solution.solution(dice)).isEqualTo(expected)
    }

}