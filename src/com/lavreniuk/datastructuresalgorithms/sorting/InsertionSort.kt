package com.lavreniuk.datastructuresalgorithms.sorting

object InsertionSort {

    fun sortAsc(array: Array<Int>): Array<Int> {
        val result = array.clone()
        for (i in 1 until result.size) {
            for (j in 0 .. i) {
                if (result[i] < result[j]) {
                    val temp = result[i]
                    result[i] = result[j]
                    result[j] = temp
                }
            }
        }
        return result
    }

    fun sortDesc(array: Array<Int>): Array<Int> {
        val result = array.clone()
        for (i in 1 until result.size) {
            for (j in 0 .. i) {
                if (result[i] > result[j]) {
                    val temp = result[i]
                    result[i] = result[j]
                    result[j] = temp
                }
            }
        }
        return result
    }

}