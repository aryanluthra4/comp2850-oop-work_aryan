fun main() {
    val words = readWordList("data/words.txt")     //Calls your readWordList function, loading all valid 5-letter words from the file into a mutable list called words.
    val target = pickRandomWord(words)     //Randomly selects one word from the list and removes it so it cannot be chosen again. This is the secret word the player must guess.

    println("Welcome to Wordle!")

    for (attempt in 1..10) {
        val guess = obtainGuess(attempt)         //Prompts the user for a guess. obtainGuess ensures the guess is valid before returning it.
        val matches = evaluateGuess(guess, target)      //Compares the guessed word with the target word and returns a list of match values.
        displayGuess(guess, matches)

        if (guess == target) {
            println("🎉 You guessed the word in $attempt attempts!")
            return
        }
    }
    println("Sorry, you ran out of attempts. The word was '$target'.")
}
