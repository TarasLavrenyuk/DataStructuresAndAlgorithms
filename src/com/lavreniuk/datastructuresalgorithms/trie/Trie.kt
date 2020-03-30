package com.lavreniuk.datastructuresalgorithms.trie

class Trie {

    private val root: Node = Node()

    fun insert(word: String) {
        if (word.isNotBlank()) {
            insert(word.trim(), root)
        }
    }

    private fun insert(word: String, node: Node) {
        if (word.isEmpty()) {
            node.endOfWord = true
            return
        }
        word[0].let { currentChar ->
            node.charMap.putIfAbsent(currentChar, Node())
            insert(word.substring(1), node.charMap[currentChar]!!)
        }
    }

    fun search(word: String): Boolean {
        if (word.isBlank()) return false
        return search(word.trim(), root)
    }

    private fun search(word: String, node: Node): Boolean {
        if (word.isEmpty()) return node.endOfWord
        val nextNode = node.charMap[word[0]]
        nextNode ?: return false
        return search(word.substring(1), nextNode)
    }

    private class Node {
        var endOfWord: Boolean = false;
        val charMap = mutableMapOf<Char, Node>()
    }
}