package com.test

class ShoppingCart (items: List[Item], offers: Map[String, Offer] = Map.empty) {
  private def groupedItems = items.groupBy(item => item.name).map((n, i) => (n, i.map(item => item.price)))

  groupedItems.foreach((name, prices) => {
    validatePrice(name, prices)
  })

  def getTotal(): Double = {

    var total = 0.0
    groupedItems.foreach((name, prices) => {
      val totalForItem = if (offers.contains(name)) offers(name).apply(prices.size, prices.head) else prices.sum
      total += totalForItem
    })
    total
  }

  private def validatePrice(name: String, prices: List[Double]) = {
    val distinctValues = prices.distinct
    if (distinctValues.size > 1) {
      throw ShoppingCartException(s"Found multiple prices for $name: $distinctValues")
    }
  }


}
