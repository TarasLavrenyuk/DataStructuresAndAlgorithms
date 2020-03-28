package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.queue.Queue
import com.lavreniuk.datastructuresalgorithms.queue.QueueIsEmptyException
import org.junit.Test
import kotlin.test.assertEquals

class QueueTest {

    @Test
    fun `size test`() {
        val queue = Queue<Int>()
        assertEquals(0, queue.size())
        queue.enqueue(123)
        queue.enqueue(657)
        queue.enqueue(12)
        queue.enqueue(756)
        assertEquals(4, queue.size())
    }

    @Test
    fun `dequeue test`() {
        val queue = Queue<Int>()
        queue.enqueue(123)
        queue.enqueue(657)
        queue.enqueue(12)

        assertEquals(123, queue.dequeue())
    }

    @Test(expected = QueueIsEmptyException::class)
    fun `dequeue empty queue test`() {
        val queue = Queue<Int>()
        queue.dequeue()
    }
}