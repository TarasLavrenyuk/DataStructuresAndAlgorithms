package com.lavreniuk.datastructuresalgorithms.sorting

import org.junit.Test
import kotlin.test.assertTrue

class QuickSortTest {

    @Test
    fun `quick sort asc test`() {
        val array: Array<Int> = arrayOf(9, 4, 6, 3, 7, 1, 2, 11, 5)

        assertTrue(array.clone().sortedArray() contentEquals QuickSort.sort(array))
    }

    @Test
    fun `quick sort desc test`() {
        val array: Array<Int> = arrayOf(9, 4, 6, 3, 7, 1, 2, 11, 5)

        assertTrue(array.clone().sortedArrayDescending() contentEquals QuickSort.sort(array, false))
    }
}