package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> = this.customers.filter {
    it.orders.filter { it.products.contains(product) }.isNotEmpty()
}.toSet()

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { it.isDelivered == true }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return this.customers.flatMap { it.orders }.flatMap { it.products }.filter { it == product }.size
}
