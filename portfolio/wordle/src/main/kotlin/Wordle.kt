// Implement the six required functions here
import java.io.File

const val WORD_LENGTH = 5

// Checks whether the word is exactly 5 letters long and only alphabetic.
fun isValid(word: String): Boolean =
    word.length == WORD_LENGTH && word.all { it.isLetter() }

// Reads a file and returns a list of valid lowercase words.
fun readWordList(filename: String): MutableList<String> =
    File(filename)
        .readLines()
        .filter { isValid(it.trim()) }
        .map { it.lowercase() }
        .toMutableList()

// Chooses and returns a random word from a list, removing it afterward.
fun pickRandomWord(words: MutableList<String>): String {
    val word = words.random()
    words.remove(word)
    return word
}

// Asks the user for a guess and ensures it is valid.
fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val input = readLine()?.trim()?.lowercase() ?: ""
        if (isValid(input)) return input
        println("Invalid guess. Please enter a $WORD_LENGTH-letter word.")
    }
}

// Compares the guess to the target word and returns match indicators.
fun evaluateGuess(guess: String, target: String): List<Int> =
    guess.mapIndexed { index, letter ->
        if (letter == target[index]) 1 else 0
    }

// Displays the guessed word with color-coded matches.
fun displayGuess(guess: String, matches: List<Int>) {
    for (i in guess.indices) {
        val letter = guess[i]
        when (matches[i]) {
            1 -> print("\u001B[32m$letter\u001B[0m") // green
            else -> print("\u001B[31m$letter\u001B[0m") // red
        }
    }
    println()
}
