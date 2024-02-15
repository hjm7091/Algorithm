package leetcode.medium.reverse_words_in_a_string

class Solution {

    fun reverseWords(s: String): String {
        return s.trim().split("\\s+".toRegex()).reversed().joinToString(" ")
    }

}