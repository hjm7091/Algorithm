package programmers.kakao2023.expressionable_binary_trees

class Solution {

    private val map = mapOf(
        1 to 0, 3 to 1, 7 to 2, 15 to 4, 31 to 8, 63 to 16,
    ) // key: binary string length, value: distance from root idx

    fun solution(numbers: LongArray): IntArray {
        return numbers.map { if (it.toString(2).canBeExpressedBinaryTree()) 1 else 0 }.toIntArray()
    }

    private fun String.canBeExpressedBinaryTree(): Boolean {
        if (length in map) return isValidBinaryTree(length / 2, map[length]!!)
        var l = this.length
        while (l !in map) l++
        val f = appendZeroForward(l)
        return f.isValidBinaryTree(f.length / 2, map[f.length]!!)
    }

    private fun String.appendZeroForward(targetLength: Int): String {
        val diff = targetLength - this.length
        return "0".repeat(diff) + this
    }

    private fun String.isValidBinaryTree(rootIdx: Int, distance: Int): Boolean {
        if (distance == 0) return true
        val leftChildIdx = rootIdx - distance
        val rightChildIdx = rootIdx + distance
        if (this[rootIdx] == '0') {
            if (this[leftChildIdx] == '1' || this[rightChildIdx] == '1') return false
        }
        return isValidBinaryTree(leftChildIdx, distance / 2) && isValidBinaryTree(rightChildIdx, distance / 2)
    }

}