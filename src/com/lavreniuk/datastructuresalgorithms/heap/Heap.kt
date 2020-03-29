package com.lavreniuk.datastructuresalgorithms.heap

class Heap {

    private var heapArray: Array<Int?> = arrayOfNulls(50)

    private var size = 0

    fun insert(data: Int) {
        val newElementPosition = size + 1
        heapArray[newElementPosition] = data
        size++
        balanceNewElement(newElementPosition)
    }

    private fun checkIfEnoughSpace() {
        if (size + 1 == heapArray.size) {
            heapArray = heapArray.copyOf(heapArray.size * 2)
        }
    }

    private fun balanceNewElement(index: Int) {
        if (index == 1) {
            return
        }
        val parentIndex = index / 2
        if (heapArray[index]!! < heapArray[parentIndex]!!) {
            swap(index, parentIndex)
        }
        balanceNewElement(parentIndex)
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = heapArray[index1]
        heapArray[index1] = heapArray[index2]
        heapArray[index2] = temp
    }

    fun getMin(): Int? {
        return heapArray[1]
    }

    fun extractMin(): Int? {
        val result = heapArray[1]
        heapArray[1] = heapArray[size]
        heapArray[size] = null
        size--


        balanceRoot(1)
        return result
    }

    private fun balanceRoot(index: Int) {
        val left = heapArray[leftChildIndex(index)]
        val right = heapArray[rightChildIndex(index)]

        // Leaf node case, node does not have any children
        if (left == null && right == null) {
            return
        }

        // In binary heap there is no case when a node has right child and
        // does not have left child, so just check if right child is null.
        // Besides that, there is no need for another function call, because
        // if a node does not have right child, that means left node is a leaf
        if (right == null) {
            swap(index, leftChildIndex(index))
            return
        }

        if (left!! < right) {
            swap(index, leftChildIndex(index))
            balanceRoot(leftChildIndex(index))
        } else {
            swap(index, rightChildIndex(index))
            balanceRoot(rightChildIndex(index))
        }
    }

    fun getOrderedArray() = heapArray.copyOfRange(1, size + 1)

    private fun leftChildIndex(parentIndex: Int) = parentIndex * 2

    private fun rightChildIndex(parentIndex: Int) = parentIndex * 2 + 1

    fun size() = size

    fun isEmpty() = size == 0
}