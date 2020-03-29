package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.heap.MaxHeap
import com.lavreniuk.datastructuresalgorithms.heap.MinHeap
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class HeapTest {

    @Test
    fun `get lowest value test`() {
        val heap = MinHeap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertEquals(3, heap.getTop())
    }

    @Test
    fun `extract lowest value test`() {
        val heap = MinHeap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertEquals(3, heap.extractTop())
        assertTrue(arrayOf(4, 43, 8, 123, 754, 1876) contentEquals heap.getAsArray())

        assertEquals(4, heap.extractTop())
        assertTrue(arrayOf(8, 43, 1876, 123, 754) contentEquals heap.getAsArray())

        assertEquals(8, heap.extractTop())
        assertTrue(arrayOf(43, 123, 1876, 754) contentEquals heap.getAsArray())
    }

    @Test
    fun `correct min heap array test`() {
        val heap = MinHeap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertTrue(arrayOf(3, 4, 8, 123, 43, 1876, 754) contentEquals heap.getAsArray())
    }

    @Test
    fun `get biggest value test`() {
        val heap = MaxHeap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertEquals(1876, heap.getTop())
    }

    @Test
    fun `extract biggest value test`() {
        val heap = MaxHeap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertEquals(1876, heap.extractTop())
        assertTrue(arrayOf(754, 43, 123, 4, 3, 8) contentEquals heap.getAsArray())

        assertEquals(754, heap.extractTop())
        assertTrue(arrayOf(123, 43, 8, 4, 3) contentEquals heap.getAsArray())

        assertEquals(123, heap.extractTop())
        assertTrue(arrayOf(43, 4, 8, 3) contentEquals heap.getAsArray())
    }

    @Test
    fun `correct max heap array test`() {
        val heap = MaxHeap()
        heap.insert(123)
        heap.insert(4)
        heap.insert(754)
        heap.insert(43)
        heap.insert(3)
        heap.insert(1876)
        heap.insert(8)

        assertTrue(arrayOf(1876, 43, 754, 4, 3, 123, 8) contentEquals heap.getAsArray())
    }
}