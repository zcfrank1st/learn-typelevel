package com.chaos.functional.exercise

/**
  * Created by zcfrank1st on 23/01/2017.
  */
object Compose extends App {
  def compose[A, B, C] (f: B => C, g: A => B): A => C = {
    (a: A) => {
      f(g(a))
    }
  }

  def int1(a: Int): Int = 1

  def int2(a: Int): Int = 2


  val func = compose(int1, int2)
  println(func(1))
}
