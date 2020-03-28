package com.lavreniuk.datastructuresalgorithms.sorting

import org.junit.Test
import kotlin.test.assertTrue

class MergeSortTest {

    @Test
    fun `merge sort asc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArray() contentEquals MergeSort.sortAsc(array))
    }

    @Test
    fun `merge sort desc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArrayDescending() contentEquals MergeSort.sortDesc(array))
    }
}