package nicestring

import java.security.KeyStore

fun String.isNice(): Boolean {
    //this a la extension
    //it a setOf("ba","be","bu")
    val noBadString = setOf("ba","be","bu").none { this.contains(it) }

    val hasThreeVowels = count{it in "aeiou"} >= 3

    var hasDouble = zipWithNext().any{it.first == it.second}
    //third
    //(0 until lastIndex).any{ this[it] == this[it+1]}
    //second option
    //windowed(2).any { it[0] == it[1] }

    return listOf(noBadString, hasThreeVowels, hasDouble).count { it }  >= 2
}