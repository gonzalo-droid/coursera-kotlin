package nicestring

import java.security.KeyStore

fun String.isNice(): Boolean {
    val noBadString = !contains("ba") && !contains("be") && !contains("bu")
    val hasThreeVowels = count{
        it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
    } >= 3

    var hasDouble = false
    if(length > 1 ){
        var prevCh: Char? = null
        this.forEach { ch ->
            if(ch == prevCh )
                hasDouble = true
            prevCh = ch
        }
    }

    var conditions= 0
    if(noBadString) conditions++
    if(hasThreeVowels) conditions++
    if(hasDouble) conditions++

    if(conditions >= 2 ) return true
    return false
}