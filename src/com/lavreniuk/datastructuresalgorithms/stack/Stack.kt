package com.lavreniuk.datastructuresalgorithms.stack

class Stack<T> {

    private var head: Node<T?>? = null
    private var size = 0

    fun push(newData: T) {
        if (isEmpty()) {
            Node<T?>(newData, head).also {
                head = it
            }
            size += 1
            return
        }
        head = Node(newData, head)
        size += 1
    }

    fun pop(): T? {
        head?.let {
            val result = it.data
            head = head!!.next
            size -= 1
            return result
        }
        throw StackIsEmptyException()
    }

    fun top(): T? {
        return head.let {
            return@let it!!.data
        } ?: throw StackIsEmptyException()
    }

    fun isEmpty() = size == 0

    fun size() = size

    fun print() {
        if (head == null) {
            println("Stack is empty.")
            return
        }
        var currentNode: Node<T?>? = head
        do {
            print("${currentNode?.data} -> ")
            currentNode = currentNode?.next
        } while (currentNode != null)
        println("null")
    }
}