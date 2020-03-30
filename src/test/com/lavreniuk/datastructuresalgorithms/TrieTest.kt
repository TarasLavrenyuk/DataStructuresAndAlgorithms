package com.lavreniuk.datastructuresalgorithms

import com.lavreniuk.datastructuresalgorithms.trie.Trie
import org.junit.Test
import kotlin.test.assertTrue

class TrieTest {

    @Test
    fun `inserted word should be searchable test`() {
        val trie = Trie()
        val word = "Hello"
        trie.insert(word)
        assertTrue(trie.search(word))
    }
}