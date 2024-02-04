package programmers.kakao2024_intern.picking_the_dice

data class Statistics(val win: Int) {
    companion object {
        fun from(a: IntArray, b: IntArray): Statistics {
            b.sort()
            var win = 0
            a.forEach { win += binarySearch(it, b) }
            return Statistics(win)
        }

        private fun binarySearch(target: Int, arr: IntArray): Int {
            var l = 0; var r = arr.size
            while (l < r) {
                val mid = (l + r) / 2
                if (arr[mid] >= target) r = mid
                else l = mid + 1
            }
            return l
        }
    }
}

class Solution {

    fun solution(dice: Array<IntArray>): IntArray {
        val n = dice.size
        val m = n / 2
        val origin = IntArray(n) { it }.toSet()
        val aChoices = mutableListOf<List<Int>>()
        combination(0, mutableListOf(), aChoices, n, m, false)
        var max = 0
        var result = listOf<Int>()
        aChoices.forEach { aChoice ->
            val bChoice = origin - aChoice.toSet()
            val aDices = dice.filterIndexed { i, _ -> i in aChoice }
            val bDices = dice.filterIndexed { i, _ -> i in bChoice }
            val aScores = scores(aDices)
            val bScores = scores(bDices)
            val statistics = Statistics.from(aScores, bScores)
            if (statistics.win > max) {
                max = statistics.win
                result = aChoice
            }
        }
        return result.map { it + 1 }.toIntArray()
    }

    private fun scores(dices: List<IntArray>): IntArray {
        val choices = mutableListOf<List<Int>>()
        combination(0, mutableListOf(), choices, 6, dices.size, true)
        val scores = mutableListOf<Int>()
        choices.forEach { choice ->
            var sum = 0
            for (i in dices.indices) sum += dices[i][choice[i]]
            scores += sum
        }
        return scores.toIntArray()
    }

    private fun combination(idx: Int, temp: MutableList<Int>, choices: MutableList<List<Int>>,
                            n: Int, m: Int, duplication: Boolean) {
        if (temp.size == m) {
            choices += mutableListOf<Int>().also { it.addAll(temp) }
            return
        }
        for (i in idx until n) {
            temp += i
            val nextIdx = if (duplication) 0 else i + 1
            combination(nextIdx, temp, choices, n, m, duplication)
            temp.removeLast()
        }
    }

}