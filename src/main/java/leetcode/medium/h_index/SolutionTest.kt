package leetcode.medium.h_index

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val citations = intArrayOf(3, 0, 6, 1, 5)
        assertThat(solution.hIndex(citations)).isEqualTo(3)
    }

    @Test
    fun test2() {
        val citations = intArrayOf(1, 3, 1)
        assertThat(solution.hIndex(citations)).isEqualTo(1)
    }

    @Test
    fun test3() {
        val citations = intArrayOf(0, 0, 1)
        assertThat(solution.hIndex(citations)).isEqualTo(1)
    }

    @Test
    fun test4() {
        val citations = intArrayOf(0, 0, 0)
        assertThat(solution.hIndex(citations)).isEqualTo(0)
    }

}