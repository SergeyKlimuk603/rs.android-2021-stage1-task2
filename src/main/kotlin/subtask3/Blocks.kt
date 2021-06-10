package subtask3

import java.lang.StringBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            Integer::class -> return returnIntSum(blockA)
            String::class -> return returnString(blockA)
            LocalDate::class -> return returnLastDate(blockA)
            else -> "Я не знаю как работать с такими объектами"
        }
    }

    private fun returnIntSum(block: Array<*>): Int {
        var sum = 0
        for (e in block) {
            if (e is Int) {
                sum += e
            }
        }
        return sum
    }

    private fun returnString(block: Array<*>): String {
        val sum = StringBuilder()
        for (e in block) {
            if (e is String) {
                sum.append(e)
            }
        }
        return sum.toString()
    }

    private fun returnLastDate(block: Array<*>): String {
        lateinit var lastDate: LocalDate
        for (e in block) {
            if (e is LocalDate) {
                lastDate = e
                break
            }
        }
        for (e in block) {
            if (e is LocalDate && e > lastDate) {
                lastDate = e
            }
        }
        println(lastDate)
        return lastDate.format(DateTimeFormatter.ofPattern("d.MM.yyyy", Locale("ru")))
    }
}
