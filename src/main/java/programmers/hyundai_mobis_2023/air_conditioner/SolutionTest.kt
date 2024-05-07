package programmers.hyundai_mobis_2023.air_conditioner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution = Solution()

    @Test
    fun case1() {
        val temperature = 28; val t1 = 18; val t2 = 26
        val a = 10; val b = 8
        val onboard = intArrayOf(0, 0, 1, 1, 1, 1, 1)
        val expected = 40
        val actual = solution.solution(temperature, t1, t2, a, b, onboard)
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun case2() {
        val temperature = -10; val t1 = -5; val t2 = 5
        val a = 5; val b = 1
        val onboard = intArrayOf(0, 0, 0, 0, 0, 1, 0)
        val expected = 25
        val actual = solution.solution(temperature, t1, t2, a, b, onboard)
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun case3() {
        val temperature = 11; val t1 = 8; val t2 = 10
        val a = 10; val b = 1
        val onboard = intArrayOf(0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1)
        val expected = 20
        val actual = solution.solution(temperature, t1, t2, a, b, onboard)
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun case4() {
        val temperature = 11; val t1 = 8; val t2 = 10
        val a = 10; val b = 100
        val onboard = intArrayOf(0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1)
        val expected = 60
        val actual = solution.solution(temperature, t1, t2, a, b, onboard)
        assertThat(expected).isEqualTo(actual)
    }

}