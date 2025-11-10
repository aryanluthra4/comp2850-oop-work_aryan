// Implement the six required functions here
import java.io.File

fun isValid(word: String): Boolean{
    return word.length == 5 && word.all {it.isLetter()}
}

fun readWordList(filename: String): MutableList<String> {
    return File(filename).readLines()
        .filter { isValid(it.trim()) }
        .map { it.lowercase() }
        .toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
    val word = words.random()
    words.remove(word)
    return word
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val input = readLine()?.trim()?.lowercase() ?: ""
        if (isValid(input)) return input
        println("Invalid guess. Please enter a 5-letter word.")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    return guess.mapIndexed { i, c -> if (c == target[i]) 1 else 0 }
}

fun displayGuess(guess: String, matches: List<Int>) {
    for (i in guess.indices) {
        print(if (matches[i] == 1) guess[i] else '?')
    }
    println()
}