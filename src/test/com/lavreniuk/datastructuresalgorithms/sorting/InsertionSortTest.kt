package com.lavreniuk.datastructuresalgorithms.sorting

import org.junit.Test
import kotlin.test.assertTrue

class InsertionSortTest {

    @Test
    fun `insertion sort acs test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArray() contentEquals InsertionSort.sortAsc(array))
    }

    @Test
    fun `insertion sort desc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArrayDescending() contentEquals InsertionSort.sortDesc(array))
    }
}