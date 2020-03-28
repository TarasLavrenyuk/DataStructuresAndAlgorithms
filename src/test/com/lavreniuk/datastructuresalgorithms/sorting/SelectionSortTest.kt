package com.lavreniuk.datastructuresalgorithms.sorting

import org.junit.Test
import kotlin.test.assertTrue

class SelectionSortTest {

    @Test
    fun `selection sort asc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArray() contentEquals SelectionSort.sortAsc(array))
    }

    @Test
    fun `selection sort desc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArrayDescending() contentEquals SelectionSort.sortDesc(array))
    }
}