package programmers.kakao2024_intern.doughnut_and_bar_graphs

import kotlin.math.max

data class Graph(val outbound: Map<Int, MutableSet<Int>>,
                 val inbound: Map<Int, MutableSet<Int>>,
                 val maxNodeNum: Int) {

    private var doughnutCnt = 0
    private var barCnt = 0
    private var eightCnt = 0

    companion object {
        fun from(edges: Array<IntArray>): Graph {
            val outbound = HashMap<Int, MutableSet<Int>>()
            val inbound = HashMap<Int, MutableSet<Int>>()
            var maxNodeNum = 1
            edges.forEach {
                val from = it[0]; val to = it[1]
                val outboundSet = outbound.getOrDefault(from, mutableSetOf())
                outboundSet.add(to); outbound[from] = outboundSet
                val inboundSet = inbound.getOrDefault(to, mutableSetOf())
                inboundSet.add(from); inbound[to] = inboundSet
                maxNodeNum = max(maxNodeNum, max(from, to))
            }
            for (i in 1 .. maxNodeNum) {
                if (i !in outbound) outbound[i] = mutableSetOf()
                if (i !in inbound) inbound[i] = mutableSetOf()
            }
            return Graph(outbound, inbound, maxNodeNum)
        }
    }

    fun findRequirements(): IntArray {
        val creationNode = findCreationNode()
        for (nodeNum in outbound[creationNode]!!) {
            dfs(nodeNum, nodeNum)
        }
        return intArrayOf(creationNode, doughnutCnt, barCnt, eightCnt)
    }

    private fun dfs(currNodeNum: Int, startNodeNum: Int) {
        val nextNodes = outbound[currNodeNum]!!
        when (nextNodes.size) {
            2 -> eightCnt++
            1 -> {
                val nextNode = nextNodes.first()
                if (nextNode == startNodeNum) {
                    doughnutCnt++
                } else {
                    dfs(nextNode, startNodeNum)
                }
            }
            0 -> barCnt++
            else -> throw IllegalStateException("Illegal state.")
        }
    }

    private fun findCreationNode(): Int {
        for (nodeNum in 1 .. maxNodeNum) {
            val outBoundCnt = outbound[nodeNum]?.size ?: 0
            val inBoundCnt = inbound[nodeNum]?.size ?: 0
            if (outBoundCnt >= 2 && inBoundCnt == 0) return nodeNum
        }
        return -1
    }
}

class Solution {

    fun solution(edges: Array<IntArray>): IntArray {
        return Graph.from(edges).findRequirements()
    }

}