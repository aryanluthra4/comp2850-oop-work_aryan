// Implement the six required functions here
import java.io.File     

fun isValid(word: String): Boolean{                                                         //checks wether the word is 5-lettered or not.
    return word.length == 5 && word.all {it.isLetter()} 
}

fun readWordList(filename: String): MutableList<String> {                                   //function that reads a file and returns a list of valid words.
    return File(filename).readLines()                          
        .filter { isValid(it.trim()) }                         
        .map { it.lowercase() }                                
        .toMutableList()                                       
}

fun pickRandomWord(words: MutableList<String>): String {                                    //chooses and returns a random word from a list.
    val word = words.random()                                 
    words.remove(word)                                                                      //Removes that word so it cannot be used again.
    return word                                             
}

fun obtainGuess(attempt: Int): String {                                                     //function that asks the user for a guess. The argument attempt is the attempt number.
    while (true) {                                                            
        print("Attempt $attempt: ")           
        val input = readLine()?.trim()?.lowercase() ?: ""        
        if (isValid(input)) return input                                                    //If the user entered a valid 5-letter word, exit the function and return it.
        println("Invalid guess. Please enter a 5-letter word.")                             //error message if the guess is invalid.
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {                              //function that compares the guess to the target word.
    return guess.mapIndexed { a, b -> if (b == target[a]) 1 else 0 }     
}

fun displayGuess(guess: String, matches: List<Int>) {                                     //function that displays guess letters with color coding.
    for (i in guess.indices) {                                   
        val letter = guess[i]                                   
        when (matches[i]) {                                     
            1 -> print("\u001B[32m$letter\u001B[0m")                                      // green
            else -> print("\u001B[31m$letter\u001B[0m")                                   // red
        }
    }
    println()
}