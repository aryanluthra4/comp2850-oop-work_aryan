fun main() {
    val words = readWordList("data/words.txt")
    val target = pickRandomWord(words)

    println("Welcome to Wordle!")

    for (attempt in 1..10) {
        val guess = obtainGuess(attempt)
        val matches = evaluateGuess(guess, target)
        displayGuess(guess, matches)

        if (guess == target) {
            println("🎉 You guessed the word in $attempt attempts!")
            return
        }
    }
    println("Sorry, you ran out of attempts. The word was '$target'.")
}
