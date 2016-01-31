package ii_collections

fun example6() {
    val sum = listOf(1, 5, 3).sum()
}

fun Customer.getTotalOrderPrice(): Double = this.orders.flatMap { order -> order.products }.sumByDouble { it.price }
