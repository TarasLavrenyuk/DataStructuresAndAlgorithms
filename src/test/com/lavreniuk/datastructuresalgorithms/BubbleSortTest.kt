package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.sorting.BubbleSort
import org.junit.Test
import kotlin.test.assertTrue

class BubbleSortTest {

    @Test
    fun `bubble sort asc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArray() contentEquals BubbleSort.sortAsc(array))
    }

    @Test
    fun `bubble sort desc test`() {
        val array: Array<Int> = arrayOf(4, 2, 78, 45, 87, 13, 98, 64)

        assertTrue(array.clone().sortedArrayDescending() contentEquals BubbleSort.sortDesc(array))
    }
}