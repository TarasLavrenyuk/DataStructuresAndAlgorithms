package com.lavreniuk.datastructuresalgorithms.queue

class Queue<T> {

    private var head: Node<T?>? = null
    private var tail: Node<T?>? = null

    private var size = 0

    fun enqueue(data: T?) {
        if (isEmpty()) {
            Node(data).also {
                head = it
                tail = it
            }
        } else {
            Node(data).also {
                tail!!.previous = it
                tail = it
            }
        }
        size++
        return
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            throw QueueIsEmptyException()
        }

        val result = head!!.data
        head = head!!.previous
        size--
        return result
    }

    fun size() = size

    fun isEmpty() = size == 0

    fun print() {
        if (isEmpty()) {
            println("Queue is empty")
        }
        var currentNode = head
        print("head <- ")
        do {
            print("${currentNode!!.data} <- ")
            currentNode = currentNode.previous
        } while (currentNode != null)
        println("tail")
    }
}