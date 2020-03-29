package com.lavreniuk.datastructuresalgorithms.heap

abstract class Heap(
    private val heapType: HeapType = HeapType.MIN_HEAP
) {

    private var heapArray: Array<Int?> = arrayOfNulls(50)

    private var size = 0

    fun insert(data: Int) {
        checkIfEnoughSpace()
        balanceNewElement(addElement(data))
    }

    fun extractTop(): Int? {
        val result = heapArray[1]
        heapArray[1] = heapArray[size]
        heapArray[size] = null
        size--

        balanceRoot(1)
        return result
    }

    fun getTop(): Int? {
        return heapArray[1]
    }

    /**
     * @return position of new element in [heapArray]
     */
    private fun addElement(data: Int): Int {
        val newElementPosition = size + 1
        heapArray[newElementPosition] = data
        size++
        return newElementPosition
    }

    private fun balanceNewElement(index: Int) {
        if (index == 1) {
            return
        }
        val parentIndex = index / 2
        if (heapType.shouldBeSwappedWithParent(heapArray[index]!!, heapArray[parentIndex]!!)) {
            swap(index, parentIndex)
            balanceNewElement(parentIndex)
        }
    }

    private fun balanceRoot(index: Int) {
        if (isEmpty()) return

        val left = heapArray[leftChildIndex(index)]
        val right = heapArray[rightChildIndex(index)]

        when (heapType.shouldBeSwapped(heapArray[index]!!, left, right)) {
            SwapCase.NO_SWAP -> return
            SwapCase.WITH_LEFT -> {
                leftChildIndex(index).let {
                    swap(index, it)
                    balanceRoot(it)
                }
            }
            SwapCase.WITH_RIGHT -> {
                rightChildIndex(index).let {
                    swap(index, it)
                    balanceRoot(it)
                }
            }
        }
    }

    private fun checkIfEnoughSpace() {
        if (size + 1 == heapArray.size) {
            heapArray = heapArray.copyOf((heapArray.size * SCALE_HEAP_SIZE_FACTOR).toInt())
        }
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = heapArray[index1]
        heapArray[index1] = heapArray[index2]
        heapArray[index2] = temp
    }

    private fun leftChildIndex(parentIndex: Int) = parentIndex * 2

    private fun rightChildIndex(parentIndex: Int) = parentIndex * 2 + 1

    fun size() = size

    fun isEmpty() = size == 0

    fun getAsArray() = heapArray.copyOfRange(1, size + 1)

    companion object {
        const val SCALE_HEAP_SIZE_FACTOR = 1.2
    }

    enum class HeapType {

        MAX_HEAP {
            override fun shouldBeSwapped(parent: Int, left: Int?, right: Int?): SwapCase {
                return if (left == null && right == null) { // the node is leaf -> no swap
                    SwapCase.NO_SWAP
                } else if (right == null) { // right child is null
                    if (parent < left!!) {
                        SwapCase.WITH_LEFT
                    } else {
                        SwapCase.NO_SWAP
                    }
                } else { // both children are not null
                    if (parent > left!! && parent > right) {
                        SwapCase.NO_SWAP
                    } else if (parent < left && parent < right) {
                        if (left > right) {
                            SwapCase.WITH_LEFT
                        } else {
                            SwapCase.WITH_RIGHT
                        }
                    } else if (left > parent) {
                        SwapCase.WITH_LEFT
                    } else {
                        SwapCase.WITH_RIGHT
                    }
                }
            }

            override fun shouldBeSwappedWithParent(child: Int, parent: Int) = child > parent
        },
        MIN_HEAP {
            override fun shouldBeSwapped(parent: Int, left: Int?, right: Int?): SwapCase {
                return if (left == null && right == null) { // the node is leaf -> no swap
                    SwapCase.NO_SWAP
                } else if (right == null) { // right child is null
                    if (parent > left!!) {
                        SwapCase.WITH_LEFT
                    } else {
                        SwapCase.NO_SWAP
                    }
                } else { // both children are not null
                    if (parent < left!! && parent < right) {
                        SwapCase.NO_SWAP
                    } else if (parent > left && parent > right) {
                        if (left < right) {
                            SwapCase.WITH_LEFT
                        } else {
                            SwapCase.WITH_RIGHT
                        }
                    } else if (left < parent) {
                        SwapCase.WITH_LEFT
                    } else {
                        SwapCase.WITH_RIGHT
                    }
                }
            }

            override fun shouldBeSwappedWithParent(child: Int, parent: Int) = child < parent
        };

        abstract fun shouldBeSwapped(parent: Int, left: Int?, right: Int?): SwapCase

        abstract fun shouldBeSwappedWithParent(child: Int, parent: Int): Boolean
    }

    enum class SwapCase {
        NO_SWAP,
        WITH_LEFT,
        WITH_RIGHT;
    }
}