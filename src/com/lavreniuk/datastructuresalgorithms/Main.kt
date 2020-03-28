package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.stack.Stack

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        println(stack.pop())
        stack.push(3)
        stack.push(4)
        println(stack.top())
        stack.push(5)
        println(stack.top())
        stack.push(6)

        stack.print()
        println(stack.size())
    }

}