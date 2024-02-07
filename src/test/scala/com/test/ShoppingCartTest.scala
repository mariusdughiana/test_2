package com.test

import org.scalatest.funsuite.AnyFunSuite

class ShoppingCartTest extends AnyFunSuite {

  test("An empty shopping cart should return 0") {
    val shoppingCart = ShoppingCart(List.empty)
    assert(shoppingCart.getTotal() == 0)
  }

  test("The total cost should be the sum of all item's prices") {
    val shoppingCart = ShoppingCart(List(Item.Apple,Item.Orange, Item.Apple, Item.Apple))
    assert(shoppingCart.getTotal() == 2.05)
  }

  test("A shopping cart with multiple prices for the same item should fail") {
    val shoppingCartEx = intercept[ShoppingCartException]{
      ShoppingCart(List(Item.Apple, Item(Item.Apple.name, Item.Apple.price / 2)))
    }
    assert(shoppingCartEx.getMessage == "Found multiple prices for Apple: List(0.6, 0.3)")
  }

}
