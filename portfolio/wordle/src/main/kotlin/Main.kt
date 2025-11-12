const val MAX_ATTEMPTS = 10

fun main() {
    val words = readWordList("data/words.txt") // Loads valid 5-letter words into a mutable list
    val target = pickRandomWord(words) // Randomly selects one as the target word

    println("Welcome to Wordle!")

    for (attempt in 1..MAX_ATTEMPTS) {
        val guess = obtainGuess(attempt) // Prompts and validates user input
        val matches = evaluateGuess(guess, target) // Compares guess with target
        displayGuess(guess, matches)

        if (guess == target) {
            println("🎉 You guessed the word in $attempt attempts!")
            return
        }
    }
    println("Sorry, you ran out of attempts. The word was '$target'.")
}
