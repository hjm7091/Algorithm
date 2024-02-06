package programmers.kakao2024_intern.n_plus_one_card_game

/*
 * 참고: https://jaimemin.tistory.com/2350
 */
class Solution {

    fun solution(coin: Int, cards: IntArray): Int {
        val target = cards.size + 1
        var answer = 1
        var myCoin = coin
        var i = cards.size / 3
        val myCards = cards.take(i).toMutableSet()
        val remains = cards.takeLast(cards.size - myCards.size).toMutableSet()
        val availableCards = mutableSetOf<Int>()
        while (i < cards.size) {

            val frontTwo = remains.take(2).toSet()
            availableCards.addAll(frontTwo)
            remains.removeAll(frontTwo)
            i += 2

            if (myCards.size >= 2 && canContinue(myCards, myCards, target)) {
                answer++
            } else if (myCards.size >= 1 && myCoin >= 1 && canContinue(myCards, availableCards, target)) {
                answer++
                myCoin -= 1
            } else if (myCoin >= 2 && canContinue(availableCards, availableCards, target)) {
                answer++
                myCoin -= 2
            } else {
                break
            }
        }
        return answer
    }

    private fun canContinue(myCards: MutableSet<Int>, availableCards: MutableSet<Int>, target: Int): Boolean {
        for (myCard in myCards) {
            val otherCard = target - myCard
            if (otherCard in availableCards) {
                myCards.remove(myCard)
                availableCards.remove(otherCard)
                return true
            }
        }
        return false
    }

}