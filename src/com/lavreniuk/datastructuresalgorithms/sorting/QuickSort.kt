package com.lavreniuk.datastructuresalgorithms.sorting

object QuickSort {

    fun sort(array: Array<Int>, asc: Boolean = true): Array<Int> {
        val result = array.clone()
        if (asc) {
            sortAsc(result, 0, array.size - 1)
        } else {
            sortDesc(result, 0, array.size - 1)
        }
        return result
    }

    private fun sortAsc(array: Array<Int>, left: Int, right: Int) {
        if (left == right) {
            return
        }
        if (right - left == 1) {
            if (array[right] < array[left]) {
                swap(array, left, right)
            }
            return
        }
        var l = left
        var pivot = l - 1
        while (l <= right) {
            if (array[l] <= array[right]) {
                pivot++
                swap(array, l, pivot)
            }
            l++
        }

        sortAsc(array, left, pivot - 1)
        sortAsc(array, pivot + 1, right)
    }

    private fun sortDesc(array: Array<Int>, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        if (right - left == 1) {
            if (array[right] > array[left]) {
                swap(array, left, right)
            }
            return
        }
        var l = left
        var pivot = l - 1
        while (l <= right) {
            if (array[l] >= array[right]) {
                pivot++
                swap(array, l, pivot)
            }
            l++
        }

        sortDesc(array, left, pivot - 1)
        sortDesc(array, pivot + 1, right)
    }

    private fun swap(array: Array<Int>, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}