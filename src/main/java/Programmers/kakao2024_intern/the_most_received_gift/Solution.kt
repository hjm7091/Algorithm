package Programmers.kakao2024_intern.the_most_received_gift

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val relationMap = HashMap<String, HashMap<String, Int>>().apply { for (friend in friends) put(friend, HashMap<String, Int>()) }
        val giveMap = HashMap<String, Int>().apply { for (friend in friends) put(friend, 0) }
        val receiveMap = HashMap<String, Int>().apply { for (friend in friends) put(friend, 0) }
        for (gift in gifts) {
            val values = gift.split(" ")
            val givePerson = values[0]; val receivePerson = values[1]
            giveMap[givePerson] = giveMap[givePerson]!! + 1
            receiveMap[receivePerson] = receiveMap[receivePerson]!! + 1
            val map = relationMap[givePerson]!!
            map[receivePerson] = map.getOrDefault(receivePerson, 0) + 1
        }
        val factorMap = HashMap<String, Int>()
        for (friend in friends) factorMap[friend] = giveMap[friend]!! - receiveMap[friend]!!
        var maxPresentCount = 0
        for (me in friends) {
            var presentCount = 0
            for (friend in friends) {
                if (me == friend) continue
                val meToFriend = relationMap[me]!![friend] ?: 0
                val friendToMe = relationMap[friend]!![me] ?: 0
                if (meToFriend > friendToMe) presentCount++
                else if (meToFriend == friendToMe) {
                    val meFactor = factorMap[me]!!
                    val friendFactor = factorMap[friend]!!
                    if (meFactor > friendFactor) presentCount++
                }
            }
            maxPresentCount = maxPresentCount.coerceAtLeast(presentCount)
        }
        return maxPresentCount
    }
}