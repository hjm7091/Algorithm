package leetcode.easy.isomorphic_strings

class Solution {

    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        for (i in s.indices) {
            if (s[i] !in map) {
                if (t[i] in map.values) return false
                map[s[i]] = t[i]
            } else {
                val prev = map[s[i]]
                if (prev != t[i]) return false
            }
        }
        return true
    }

}