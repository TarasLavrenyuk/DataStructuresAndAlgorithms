package com.lavreniuk.datastructuresalgorithms.sorting

import com.lavreniuk.datastructuresalgorithms.heap.MaxHeap
import com.lavreniuk.datastructuresalgorithms.heap.MinHeap

object HeapSort {

    fun sortAsc(array: Array<Int>) = sort(array)

    fun sortDesc(array: Array<Int>) = sort(array, false)

    private fun sort(array: Array<Int>, asc: Boolean = true): Array<Int> {
        val heap = if (asc) MinHeap() else MaxHeap()
        for (i in array) {
            heap.insert(i)
        }

        val result = arrayOfNulls<Int>(array.size)
        for (i in result.indices) {
            result[i] = heap.extractTop()
        }
        return result as Array<Int>
    }

}