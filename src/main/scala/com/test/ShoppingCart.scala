package com.test

class ShoppingCart (items: List[Item]) {
  private def groupedItems = items.groupBy(item => item.name).map((n, i) => (n, i.map(item => item.price)))

  groupedItems.foreach((name, prices) => {
    validatePrice(name, prices)
  })

  def getTotal(): Double = {

    var total = 0.0
    groupedItems.foreach((name, prices) => {
      total += prices.sum
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
