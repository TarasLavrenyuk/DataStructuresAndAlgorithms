package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.heap.Heap
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HeapTest {

    @Test
    fun `get lowest value test`() {
        val heap = Heap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertEquals(3, heap.getMin())
    }

    @Test
    fun `extract lowest value test`() {
        val heap = Heap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertEquals(3, heap.extractMin())
        assertTrue(arrayOf(4, 43, 8, 123, 754, 1876) contentEquals heap.getOrderedArray())

        assertEquals(4, heap.extractMin())
        assertTrue(arrayOf(8, 43, 1876, 123, 754) contentEquals heap.getOrderedArray())

        assertEquals(8, heap.extractMin())
        assertTrue(arrayOf(43, 123, 1876, 754) contentEquals heap.getOrderedArray())
    }

    @Test
    fun `correct array test`() {
        val heap = Heap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertTrue(arrayOf(3, 4, 8, 123, 43, 1876, 754) contentEquals heap.getOrderedArray())
    }
}