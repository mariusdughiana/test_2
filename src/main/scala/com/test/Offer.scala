package com.test

enum Offer (calc: (Int, Double) => Double) {
  case ThreeForThePriceOfTwo extends Offer((count: Int, price: Double )=> (count/3) * price*2 + (count % 3) * price)
  case TwoForThePriceOfOne extends Offer((count: Int, price: Double )=> (count/2) * price + (count % 2) * price)

  def apply = calc



}