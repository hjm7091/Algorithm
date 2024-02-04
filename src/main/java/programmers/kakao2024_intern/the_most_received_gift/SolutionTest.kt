package programmers.kakao2024_intern.the_most_received_gift

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun test1() {
        val friends = arrayOf("muzi", "ryan", "frodo", "neo")
        val gifts = arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi")
        assertThat(solution.solution(friends, gifts)).isEqualTo(2)
    }

    @Test
    fun test2() {
        val friends = arrayOf("joy", "brad", "alessandro", "conan", "david")
        val gifts = arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david")
        assertThat(solution.solution(friends, gifts)).isEqualTo(4)
    }

    @Test
    fun test3() {
        val friends = arrayOf("a", "b", "c")
        val gifts = arrayOf("a b", "b a", "c a", "a c", "a c", "c a")
        assertThat(solution.solution(friends, gifts)).isEqualTo(0)
    }

}