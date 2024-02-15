package leetcode.medium.reverse_words_in_a_string

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val s = "the sky is blue"
        assertThat(solution.reverseWords(s)).isEqualTo("blue is sky the")
    }

    @Test
    fun test2() {
        val s = "  hello world  "
        assertThat(solution.reverseWords(s)).isEqualTo("world hello")
    }

    @Test
    fun test3() {
        val s = "a good   example"
        assertThat(solution.reverseWords(s)).isEqualTo("example good a")
    }

}