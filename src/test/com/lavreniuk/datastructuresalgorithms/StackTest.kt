package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.stack.Stack
import com.lavreniuk.datastructuresalgorithms.stack.StackIsEmptyException
import org.junit.Test
import kotlin.test.assertEquals


class StackTest {

    @Test
    fun `size test`() {
        val stack = Stack<Int>()
        stack.push(3)
        stack.push(4)
        stack.push(1)
        stack.push(3)
        assertEquals(4, stack.size())
        stack.pop()
        assertEquals(3, stack.size())
    }

    @Test
    fun `pop test`() {
        val stack = Stack<Int>()
        stack.push(436)
        stack.push(43524)
        stack.push(123)
        stack.push(8567)
        assertEquals(8567, stack.pop())
        assertEquals(3, stack.size())
    }

    @Test
    fun `top test`() {
        val stack = Stack<Int>()
        stack.push(436)
        stack.push(43524)
        assertEquals(43524, stack.top())
        assertEquals(2, stack.size())
    }

    @Test(expected = StackIsEmptyException::class)
    fun `top from empty stack test`() {
        val stack = Stack<Int>()
        stack.top()
    }

    @Test(expected = StackIsEmptyException::class)
    fun `pop from empty stack test`() {
        val stack = Stack<Int>()
        stack.pop()
    }
}