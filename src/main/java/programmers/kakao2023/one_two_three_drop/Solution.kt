package programmers.kakao2023.one_two_three_drop

import java.util.*

data class Graph(val nodeMap: MutableMap<Int, List<Int>>,
                 val leafNodeMap: MutableMap<Int, List<Int>>,
                 val targetMap: Map<Int, Int>) {

    companion object {
        fun from(edges: Array<IntArray>, target: IntArray): Graph {
            val maxNodeNum = edges.size + 1
            val nodeMap = mutableMapOf<Int, List<Int>>()
            edges.forEach { nodeMap[it[0]] = nodeMap.getOrDefault(it[0], emptyList()) + it[1] }
            nodeMap.keys.forEach { nodeMap[it] = nodeMap[it]!!.sorted() }
            val leafNodeMap = mutableMapOf<Int, List<Int>>()
            val targetMap = mutableMapOf<Int, Int>()
            for (num in 1 .. maxNodeNum) {
                if (num !in nodeMap) {
                    nodeMap[num] = emptyList()
                    leafNodeMap[num] = emptyList()
                    targetMap[num] = target[num - 1]
                }
            }
            return Graph(nodeMap, leafNodeMap, targetMap)
        }

    }

    fun canFindAnswer(): Boolean {
        var num = 1
        while (canContinue()) {
            drop(num++)
            if (canStop()) return true
        }
        return false
    }

    private fun canStop(): Boolean {
        return leafNodeMap.all { (nodeNum, numbers) ->
            val target = targetMap[nodeNum]!!
            val size = numbers.size
            target <= size * 3
        }
    }

    private fun canContinue(): Boolean {
        return leafNodeMap.all { (nodeNum, numbers) ->
            val target = targetMap[nodeNum]!!
            numbers.size <= target
        }
    }

    private fun drop(number: Int) {
        var nodeNum = 1
        val visitNodes = mutableListOf<Int>()
        while (nodeNum != -1) {
            visitNodes += nodeNum
            nodeNum = nodeMap[nodeNum]!!.firstOrNull() ?: -1
        }
        val leafNodeNum = visitNodes.removeLast()
        leafNodeMap[leafNodeNum] = leafNodeMap[leafNodeNum]!! + number
        visitNodes.forEach { Collections.rotate(nodeMap[it]!!, -1) }
    }

}

class Solution {

    fun solution(edges: Array<IntArray>, target: IntArray): IntArray {
        val graph = Graph.from(edges, target)

        val canFindAnswer = graph.canFindAnswer()
        if (!canFindAnswer) return intArrayOf(-1)

        val leafNodeMap = graph.leafNodeMap
        val targetMap = graph.targetMap

        val answer = IntArray(leafNodeMap.values.sumOf { it.size }) { -1 }
        leafNodeMap.forEach { (nodeNum, numbers) ->
            val greedyArray = createGreedyArray(targetMap[nodeNum]!!, numbers.size)
            numbers.forEachIndexed { i, number ->
                answer[number - 1] = greedyArray[i]
            }
        }

        return answer
    }

    private fun createGreedyArray(target: Int, size: Int): IntArray {
        val arr = IntArray(size) { 1 }
        var remain = target - size
        var idx = size - 1
        while (remain > 0) {
            val add = if (remain >= 2) 2 else 1
            remain -= add
            arr[idx--] += add
        }
        return arr
    }

}