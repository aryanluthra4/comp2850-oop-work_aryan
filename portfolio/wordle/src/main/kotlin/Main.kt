
fun main() {
    // Calls readWordList function, loading all valid 5-letter words
    // from the file into a mutable list called words.
    val words = readWordList("data/words.txt")

    // Randomly selects one word from the list and removes it so it cannot
    // be chosen again. This is the secret word the player must guess.
    val target = pickRandomWord(words)

    println("Welcome to Wordle!")

    for (attempt in 1..10) {
        // Prompts the user for a guess. obtainGuess ensures the guess is
        // valid before returning it.
        val guess = obtainGuess(attempt)

        // Compares the guessed word with the target word and returns a list
        // of match values.
        val matches = evaluateGuess(guess, target)

        displayGuess(guess, matches)

        if (guess == target) {
            println("🎉 You guessed the word in $attempt attempts!")
            return
        }
    }