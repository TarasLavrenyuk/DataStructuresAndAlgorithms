package com.lavreniuk.datastructuresalgorithms.sorting

object MergeSort {

    fun sortAsc(array: Array<Int>): Array<Int> {
        val size = array.size
        if (size < 2) {
            return array
        }
        return merge(sortAsc(array.copyOfRange(0, size / 2)), sortAsc(array.copyOfRange(size / 2, size)))
    }

    fun sortDesc(array: Array<Int>): Array<Int> {
        val size = array.size
        if (size < 2) {
            return array
        }
        return merge(sortDesc(array.copyOfRange(0, size / 2)), sortDesc(array.copyOfRange(size / 2, size)), false)
    }

    private fun merge(array1: Array<Int>, array2: Array<Int>, asc: Boolean = true): Array<Int> {
        val resultArrSize = array1.size + array2.size
        val result = arrayOfNulls<Int>(resultArrSize)
        var index1 = 0
        var index2 = 0

        do {
            if (asc) {
                if (array1[index1] <= array2[index2]) {
                    result[index1 + index2] = array1[index1]
                    index1++
                } else {
                    result[index1 + index2] = array2[index2]
                    index2++
                }
            } else {
                if (array1[index1] >= array2[index2]) {
                    result[index1 + index2] = array1[index1]
                    index1++
                } else {
                    result[index1 + index2] = array2[index2]
                    index2++
                }
            }
        } while (index1 != array1.size && index2 != array2.size)
        if (index2 != array2.size) {
            copyRestElements(index2, array2, result, index1)
        }
        if (index1 != array1.size) {
            copyRestElements(index1, array1, result, index2)
        }
        return result as Array<Int>
    }

    private fun copyRestElements(
        index: Int,
        originalArr: Array<Int>,
        destinationArr: Array<Int?>,
        offset: Int
    ) {
        for (i in index until originalArr.size) {
            destinationArr[offset + i] = originalArr[i]
        }
    }
}
