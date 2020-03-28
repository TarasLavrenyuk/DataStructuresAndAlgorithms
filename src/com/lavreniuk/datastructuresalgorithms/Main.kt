package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.queue.Queue

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val queue = Queue<Int>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        queue.enqueue(4)
        queue.enqueue(5)

        queue.print()
    }
}