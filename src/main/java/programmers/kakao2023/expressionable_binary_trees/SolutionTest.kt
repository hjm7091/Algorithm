package programmers.kakao2023.expressionable_binary_trees

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SolutionTest {

    val solution = Solution()

    @Test
    fun case1() {
        val numbers = longArrayOf(7, 42, 5)
        val expected = intArrayOf(1, 1, 0)
        val actual = solution.solution(numbers)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case2() {
        val numbers = longArrayOf(63, 111, 95)
        val expected = intArrayOf(1, 1, 0)
        val actual = solution.solution(numbers)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case3() {
        val numbers = longArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555)
        val expected = intArrayOf(1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1)
        val actual = solution.solution(numbers)
        assertContentEquals(expected, actual)
    }

}