package com.lavreniuk.datastructuresalgorithms.trie

class Trie {

    private val root: Node = Node()

    fun insert(word: String) {
        if (word.isNotBlank()) {
            insert(word.trim(), root)
        }
    }

    private fun insert(word: String, node: Node) {
        if (word.isBlank()) {
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

    fun delete(word: String): Boolean {
        if (word.isBlank()) return false
        return delete(word, root)
    }

    private fun delete(word: String, currentNode: Node): Boolean {
        if (word.isEmpty()) {
            if (currentNode.endOfWord) {
                currentNode.endOfWord = false
                return true
            }
        }
        val currentChar = word[0]
        currentNode.charMap[currentChar]?.let { nextNode ->
            if (delete(word.substring(1), nextNode)) {
                if (nextNode.charMap.isEmpty() && !nextNode.endOfWord) {
                    currentNode.charMap.remove(currentChar)
                }
                return true
            }
        }
        return false
    }


    private class Node {
        var endOfWord: Boolean = false;
        val charMap = mutableMapOf<Char, Node>()
    }
}