package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val a = a.toLowerCase()
        val b = b.toLowerCase()
        var indexB = 0;  // позиция буквы в строке "b"
        for (letter in a) {
            if (letter == b[indexB]) {
                if (indexB >= b.lastIndex) {
                    return "YES"
                }
                indexB++
            }
        }
        return "NO"
    }
}
