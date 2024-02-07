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

  test("The total cost of 5 apples on ThreeForThePriceOfTwo offer and 3 oranges on TwoForThePriceOfOne offer should be as much as full prices for 4 apples and 2 oranges") {
    val shoppingCart = ShoppingCart(
      List(Item.Apple, Item.Orange, Item.Apple, Item.Apple, Item.Apple, Item.Apple, Item.Orange, Item.Orange),
      Map(
        Item.Apple.name -> Offer.ThreeForThePriceOfTwo,
        Item.Orange.name -> Offer.TwoForThePriceOfOne
      ))
    assert(shoppingCart.getTotal() == Item.Apple.price*4 + Item.Orange.price*2)
  }

}
