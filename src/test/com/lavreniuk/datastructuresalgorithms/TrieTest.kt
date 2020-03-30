package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.trie.Trie
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TrieTest {

    @Test
    fun `inserted word should be searchable test`() {
        val trie = Trie()
        val word = "Hello"
        assertFalse(trie.search(word))
        trie.insert(word)
        assertTrue(trie.search(word))
    }

    @Test
    fun `not existing word should not be deleted`() {
        val trie = Trie()
        val word = "Hello"
        val word1 = "Hello1"
        trie.insert(word)
        assertTrue(trie.search(word))
        assertFalse(trie.delete(word1))
        assertTrue(trie.search(word))
    }

    @Test
    fun `deleting subword should work`() {
        val trie = Trie()
        val word1 = "Hello"
        val word2 = "Hello1"
        trie.insert(word1)
        trie.insert(word2)
        assertTrue(trie.search(word1))
        assertTrue(trie.search(word2))

        assertTrue(trie.delete(word1))

        assertFalse(trie.search(word1))
        assertTrue(trie.search(word2))
    }
}