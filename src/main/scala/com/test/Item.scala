package com.test


class Item (namec: String, pricec: Double){
  def price = pricec
  def name = namec

}

object Item {
  def Apple = Item("Apple", 0.6)
  def Orange = Item("Orange", 0.25)
}
