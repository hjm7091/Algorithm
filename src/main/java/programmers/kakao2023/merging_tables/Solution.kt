package programmers.kakao2023.merging_tables

class Board {
    val size = 51
    val empty = "EMPTY"
    val default = -1
    var groupNumCounter = 0
    val groupMap = HashMap<Int, HashSet<Pair<Int, Int>>>()
    val groupArray = Array<Array<Int>>(size) { Array<Int>(size) { default } }
    val valueArray = Array<Array<String>>(size) { Array<String>(size) { empty } }
    val printList = ArrayList<String>()

    fun acceptCommands(raws: Array<String>) {

        for (raw in raws) {

            val splitValues = raw.split(" ")
            val command = splitValues[0]
            val values = splitValues.drop(1)

            when (command) {
                "UPDATE" -> {
                    if (values.size == 3) {
                        val r = values[0].toInt(); val c = values[1].toInt(); val v = values[2]
                        val groupNum = groupArray[r][c]
                        if (groupNum == default) {
                            valueArray[r][c] = v
                        } else {
                            groupMap[groupNum]!!.forEach { valueArray[it.first][it.second] = v }
                        }
                    } else if (values.size == 2) {
                        val before = values[0]; val after = values[1]
                        for (r in 1 until size) {
                            for (c in 1 until size) {
                                if (valueArray[r][c] == before) {
                                    valueArray[r][c] = after
                                }
                            }
                        }
                    }
                }
                "MERGE" -> {
                    val r1 = values[0].toInt(); val c1 = values[1].toInt()
                    val r2 = values[2].toInt(); val c2 = values[3].toInt()
                    if (r1 == r2 && c1 == c2) continue
                    val groupNum1 = groupArray[r1][c1]
                    val groupNum2 = groupArray[r2][c2]
                    val value1 = valueArray[r1][c1]
                    val value2 = valueArray[r2][c2]
                    if (groupNum1 == default && groupNum2 == default) {
                        val newGroupNum = ++groupNumCounter
                        groupArray[r1][c1] = newGroupNum
                        groupArray[r2][c2] = newGroupNum
                        groupMap[newGroupNum] = HashSet<Pair<Int, Int>>().apply {
                            add(Pair(r1, c1)); add(Pair(r2, c2))
                        }
                        groupMap[newGroupNum]!!.forEach {
                            valueArray[it.first][it.second] = if (value1 == empty && value2 != empty) value2 else value1
                        }
                    } else if (groupNum1 != default && groupNum2 == default) {
                        groupArray[r2][c2] = groupNum1
                        groupMap[groupNum1]!! += Pair(r2, c2)
                        groupMap[groupNum1]!!.forEach {
                            valueArray[it.first][it.second] = if (value1 == empty && value2 != empty) value2 else value1
                        }
                    } else if (groupNum1 == default && groupNum2 != default) {
                        groupArray[r1][c1] = groupNum2
                        groupMap[groupNum2]!! += Pair(r1, c1)
                        groupMap[groupNum2]!!.forEach {
                            valueArray[it.first][it.second] = if (value1 == empty && value2 != empty) value2 else value1
                        }
                    } else {
                        if (groupNum1 == groupNum2) continue
                        val newGroupNum = ++groupNumCounter
                        val mergedCells = HashSet<Pair<Int, Int>>().apply {
                            addAll(groupMap[groupNum1]!!); addAll(groupMap[groupNum2]!!)
                        }
                        mergedCells.forEach {
                            groupArray[it.first][it.second] = newGroupNum
                            valueArray[it.first][it.second] = if (value1 == empty && value2 != empty) value2 else value1
                        }
                        groupMap.remove(groupNum1)
                        groupMap.remove(groupNum2)
                        groupMap[newGroupNum] = mergedCells
                    }
                }
                "UNMERGE" -> {
                    val r = values[0].toInt(); val c = values[1].toInt()
                    val v = valueArray[r][c]
                    val groupNum = groupArray[r][c]
                    if (groupNum != default) {
                        groupMap[groupNum]!!.forEach {
                            groupArray[it.first][it.second] = default
                            valueArray[it.first][it.second] = empty
                        }
                        groupMap.remove(groupNum)
                        valueArray[r][c] = v
                    }
                }
                "PRINT" -> {
                    val r = values[0].toInt(); val c = values[1].toInt()
                    printList += valueArray[r][c]
                }
                else -> throw IllegalStateException("Illegal command: $command")
            }

        }

    }
}

class Solution {

    fun solution(commands: Array<String>): Array<String> {
        val board = Board()
        board.acceptCommands(commands)
        return board.printList.toTypedArray()
    }

}