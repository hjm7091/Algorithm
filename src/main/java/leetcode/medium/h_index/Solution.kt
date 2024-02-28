package leetcode.medium.h_index

class Solution {

    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        for (i in citations.size - 1 downTo 0) {
            val hIndex = i + 1
            if (citations[i] >= hIndex) return hIndex
        }
        return 0
    }

}