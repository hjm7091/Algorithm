package programmers.kakao2024_intern.n_plus_one_card_game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val coin = 4
        val cards = intArrayOf(3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4)
        assertThat(solution.solution(coin, cards)).isEqualTo(5)
    }

    @Test
    fun test2() {
        val coin = 3
        val cards = intArrayOf(1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12)
        assertThat(solution.solution(coin, cards)).isEqualTo(2)
    }

    @Test
    fun test3() {
        val coin = 2
        val cards = intArrayOf(5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7)
        assertThat(solution.solution(coin, cards)).isEqualTo(4)
    }

    @Test
    fun test4() {
        val coin = 10
        val cards = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18)
        assertThat(solution.solution(coin, cards)).isEqualTo(1)
    }

}