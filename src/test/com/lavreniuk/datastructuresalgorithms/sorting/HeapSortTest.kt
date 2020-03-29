package com.lavreniuk.datastructuresalgorithms.sorting

import org.junit.Test
import kotlin.test.assertTrue

class HeapSortTest {

    @Test
    fun `heap sort asc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArray() contentEquals HeapSort.sortAsc(array))
    }

    @Test
    fun `heap sort desc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArrayDescending() contentEquals HeapSort.sortDesc(array))
    }

}