package leetcode.easy.ransom_note

class Solution {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomNoteMap = ransomNote.toOccurrenceMap()
        val magazineMap = magazine.toOccurrenceMap()
        ransomNoteMap.forEach { (k, v) ->
            if (k !in magazineMap) return false
            if (v > magazineMap[k]!!) return false
        }
        return true
    }

    private fun String.toOccurrenceMap(): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        for (c in this) map[c] = map.getOrDefault(c, 0) + 1
        return map
    }

}