package leetcode.easy.isomorphic_strings

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val s = "egg"
        val t = "add"
        assertThat(solution.isIsomorphic(s, t)).isTrue()
    }

    @Test
    fun test2() {
        val s = "foo"
        val t = "bar"
        assertThat(solution.isIsomorphic(s, t)).isFalse()
    }

    @Test
    fun test3() {
        val s = "paper"
        val t = "title"
        assertThat(solution.isIsomorphic(s, t)).isTrue()
    }

    @Test
    fun test4() {
        val s = "bbbaaaba"
        val t = "aaabbbba"
        assertThat(solution.isIsomorphic(s, t)).isFalse()
    }

    @Test
    fun test5() {
        val s = "badc"
        val t = "baba"
        assertThat(solution.isIsomorphic(s, t)).isFalse()
    }

}