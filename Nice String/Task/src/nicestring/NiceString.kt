package nicestring

fun String.isNice(): Boolean {
    fun containsDoubleLetters(): Boolean {
        for ((index, ch) in this.withIndex()) {
            //solo un caracter
            if (index + 1 == this.length) return false
            //caracteres consecutivos iguales
            if (ch == this[index + 1]) return true
        }
        return false
    }

    fun containsThreeVowels():Boolean{
        val vowels = listOf('a','b','c','o','u')
        return filter {
            it -> vowels.contains(it)
        }.count() >= 3
    }

    fun containsSubstrings(): Boolean {
        val substrings = listOf("bu", "ba", "be")
        substrings.forEach { substring -> if (contains(substring)) return true }
        return false;
    }

    return listOf(containsDoubleLetters(), !containsSubstrings(), containsThreeVowels())
        .filter { it }
        .count() >= 2
}