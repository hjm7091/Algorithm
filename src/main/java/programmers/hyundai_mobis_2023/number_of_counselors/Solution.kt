package programmers.hyundai_mobis_2023.number_of_counselors

import java.util.*

data class ConsultType(var mentorNum: Int, val reqs: MutableList<Pair<Int, Int>>) {
    fun processReqs(): Int {
        val q = PriorityQueue<Int>()
        var remainMentorNum = mentorNum
        var waitTime = 0
        for ((start, taken) in reqs) {
            if (remainMentorNum > 0) {
                q.offer(start + taken)
                remainMentorNum--
            } else {
                val nextPossible = q.poll()
                val gap = nextPossible - start
                if (gap > 0) {
                    waitTime += gap
                    q.offer(start + gap + taken)
                } else {
                    q.offer(start + taken)
                }
            }
        }
        return waitTime
    }
}

class Solution {
    fun solution(k: Int, n: Int, reqs: Array<IntArray>): Int {
        val consultTypeMap = mutableMapOf<Int, ConsultType>()
        for (i in 1 .. k) consultTypeMap[i] = ConsultType(1, mutableListOf())
        for (req in reqs) consultTypeMap[req[2]]!!.reqs += Pair(req[0], req[1])
        var remainMentorNum = n - k
        while (remainMentorNum-- > 0) {
            findMentorRequiredConsultType(consultTypeMap).mentorNum++
        }
        return consultTypeMap.map { it.value.processReqs() }.sum()
    }

    private fun findMentorRequiredConsultType(consultTypeMap: Map<Int, ConsultType>): ConsultType {
        var prevGap = -1
        var mentorRequiredConsultType: ConsultType? = null
        for (i in 1 .. consultTypeMap.size) {
            val consultType = consultTypeMap[i]!!
            val prevWaitTime = consultType.processReqs()
            consultType.mentorNum++
            val afterWaitTime = consultType.processReqs()
            val gap = Math.abs(prevWaitTime - afterWaitTime)
            if (gap > prevGap) {
                prevGap = gap
                mentorRequiredConsultType = consultType
            }
            consultType.mentorNum--
        }
        return mentorRequiredConsultType!!
    }
}