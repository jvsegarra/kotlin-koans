package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val myCalendar: Calendar = GregorianCalendar(year, month, dayOfMonth)
        val otherCalendar: Calendar = GregorianCalendar(other.year, other.month, other.dayOfMonth)

        return myCalendar.compareTo(otherCalendar);
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(d: MyDate): Boolean {
        return (start <= d) && (d <= endInclusive)
    }

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var cursor = start;

            override fun next(): MyDate {
                val current = cursor
                cursor = cursor.nextDay()
                return current
            }

            override fun hasNext(): Boolean = cursor <= endInclusive
        }
    }
}
