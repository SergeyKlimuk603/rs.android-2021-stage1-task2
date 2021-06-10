package subtask1

import java.lang.NumberFormatException
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val formatter = DateTimeFormatter.ofPattern("d MMMM, eeee", Locale("ru"))
        lateinit var newDate: LocalDate
        try {
            newDate = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch(e: DateTimeException) {
            return "Такого дня не существует"
        } catch(e: NumberFormatException) {
            return "Некорректные входные данные"
        }
        return newDate.format(formatter)
    }
}
