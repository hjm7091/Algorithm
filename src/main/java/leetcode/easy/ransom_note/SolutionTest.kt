package leetcode.easy.ransom_note

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val ransomNote = "a"
        val magazine = "b"
        assertThat(solution.canConstruct(ransomNote, magazine)).isFalse()
    }

    @Test
    fun test2() {
        val ransomNote = "aa"
        val magazine = "ab"
        assertThat(solution.canConstruct(ransomNote, magazine)).isFalse()
    }

    @Test
    fun test3() {
        val ransomNote = "aa"
        val magazine = "aab"
        assertThat(solution.canConstruct(ransomNote, magazine)).isTrue()
    }

    @Test
    fun test4() {
        val ransomNote = "aaaa"
        val magazine = "aaaaa"
        assertThat(solution.canConstruct(ransomNote, magazine)).isTrue()
    }

}