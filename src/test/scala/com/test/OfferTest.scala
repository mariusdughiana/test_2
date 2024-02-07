package com.test

import org.scalatest.funsuite.AnyFunSuite

class OfferTest extends AnyFunSuite {

  test("Five items with the ThreeForThePriceOfTwo offer should cost as four full prices") {
    val shoppingCart = ShoppingCart(List.empty)
    assert(Offer.ThreeForThePriceOfTwo.apply(5, 1) == 4)
  }

  test("Three items with the TwoForThePriceOfOne offer should cost as two full prices") {
    val shoppingCart = ShoppingCart(List.empty)
    assert(Offer.TwoForThePriceOfOne.apply(3, 1) == 2)
  }



}
