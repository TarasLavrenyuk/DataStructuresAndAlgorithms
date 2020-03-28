package com.lavreniuk.datastructuresalgorithms.sorting

object BubbleSort {

    fun sortAsc(array: Array<Int>): Array<Int> {
        val result = array.clone()
        for (i in array.indices) {
            for (j in 0 until array.size - i - 1) {
                if (result[j] > result[j + 1]) {
                    val temp = result[j]
                    result[j] = result[j + 1]
                    result[j + 1] = temp
                }
            }
        }
        return result
    }

    fun sortDesc(array: Array<Int>): Array<Int> {
        val result = array.clone()
        for (i in array.indices) {
            for (j in 0 until array.size - i - 1) {
                if (result[j] < result[j + 1]) {
                    val temp = result[j]
                    result[j] = result[j + 1]
                    result[j + 1] = temp
                }
            }
        }
        return result
    }

}