import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({

    "isValid returns true for valid 5-letter words" {
        isValid("apple") shouldBe true
        isValid("app1e") shouldBe false
        isValid("app") shouldBe false
    }

    "pickRandomWord removes the selected word" {
        val words = mutableListOf("apple", "berry", "cherry")
        val selected = pickRandomWord(words)
        words.contains(selected) shouldBe false
    }

    "evaluateGuess basic match checking" {
        evaluateGuess("apple", "apple") shouldBe listOf(1, 1, 1, 1, 1)
        evaluateGuess("apple", "berry") shouldBe listOf(0, 0, 0, 0, 0)
    }
})
