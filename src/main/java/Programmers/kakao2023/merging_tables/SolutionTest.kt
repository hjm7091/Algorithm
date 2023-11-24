package Programmers.kakao2023.merging_tables

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SolutionTest {

    val solution = Solution()

    @Test
    fun case1() {
        val commands = arrayOf("UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4")
        val expected = arrayOf("EMPTY", "group")
        val actual = solution.solution(commands)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case2() {
        val commands = arrayOf("UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1")
        val expected = arrayOf("d", "EMPTY")
        val actual = solution.solution(commands)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case3() {
        val commands = arrayOf("UPDATE 1 1 menu", "MERGE 1 1 1 2", "MERGE 1 1 1 3", "MERGE 1 1 1 4", "MERGE 1 2 1 3", "UPDATE 1 1 hansik", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4")
        val expected = arrayOf("hansik", "hansik", "hansik", "hansik")
        val actual = solution.solution(commands)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case4() {
        val commands = arrayOf("MERGE 1 1 2 2", "UPDATE 1 1 A", "UNMERGE 1 1", "PRINT 1 1", "PRINT 2 2")
        val expected = arrayOf("A", "EMPTY")
        val actual = solution.solution(commands)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case5() {
        val commands = arrayOf("UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 3 3", "UNMERGE 1 1", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4")
        val expected = arrayOf("A", "EMPTY", "EMPTY", "EMPTY")
        val actual = solution.solution(commands)
        assertContentEquals(expected, actual)
    }

    @Test
    fun case6() {
        val commands = arrayOf("MERGE 1 1 1 2", "UPDATE 1 3 hansik", "MERGE 1 2 1 3", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3")
        val expected = arrayOf("hansik", "hansik", "hansik")
        val actual = solution.solution(commands)
        assertContentEquals(expected, actual)
    }

}