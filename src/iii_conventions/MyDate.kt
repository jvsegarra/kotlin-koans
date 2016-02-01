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

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate =
        this.addTimeIntervals(repeatedTimeInterval.ti, repeatedTimeInterval.n)

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

operator fun TimeInterval.times(repetitions: Int) = RepeatedTimeInterval(this, repetitions);

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
