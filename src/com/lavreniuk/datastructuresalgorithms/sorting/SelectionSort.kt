package com.lavreniuk.datastructuresalgorithms.sorting

object SelectionSort {

    fun sortAsc(array: Array<Int>): Array<Int> {
        val result = array.clone()
        for (i in result.indices) {
            var maxValueIndex = 0
            for (j in 0 until result.size - i) {
                if (result[j] > result[maxValueIndex]) {
                    maxValueIndex = j
                }
            }
            val temp = result[maxValueIndex]
            result[maxValueIndex] = result[array.size - 1 - i]
            result[array.size - 1 - i] = temp
        }
        return result
    }

    fun sortDesc(array: Array<Int>): Array<Int> {
        val result = array.clone()
        for (i in result.indices) {
            var maxValueIndex = i
            for (j in i until result.size) {
                if (result[j] > result[maxValueIndex]) {
                    maxValueIndex = j
                }
            }
            val temp = result[maxValueIndex]
            result[maxValueIndex] = result[i]
            result[i] = temp
        }
        return result
    }
}