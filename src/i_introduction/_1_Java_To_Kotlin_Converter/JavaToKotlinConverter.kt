package i_introduction._1_Java_To_Kotlin_Converter

import util.TODO
import java.util.*

fun todoTask1(collection: Collection<Int>): Nothing = TODO(
        """
        Task 1.
        Rewrite JavaCode1.task1 in Kotlin.
        In IntelliJ, you can just copy-paste the code and agree to automatically convert it to Kotlin,
        but only for this task!
    """,
        references = { JavaCode1().task1(collection) })

fun createStringFromCollectionWithStringJoiner(collection: Collection<Int>): String {
    val joiner: StringJoiner = StringJoiner(", ", "{", "}");

    for (item in collection) {
        joiner.add(item.toString());
    }

    return joiner.toString();
}

fun convertCodeFromJavaCollection(collection: Collection<Int>): String {
    val sb = StringBuilder()
    sb.append("{")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("}")
    return sb.toString()
}

fun task1(collection: Collection<Int>): String = createStringFromCollectionWithStringJoiner(collection)
