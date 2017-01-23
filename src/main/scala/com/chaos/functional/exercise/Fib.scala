package com.chaos.functional.exercise

/**
  * Created by zcfrank1st on 23/01/2017.
  */
object Fib extends App {
  def fib(n: Int): Int = {
    n match {
      case 1 => 0
      case 2 => 1
      case _ => fib(n - 1) + fib(n - 2)
    }
  }

  println(fib(1))
  println(fib(2))
  println(fib(7))
}
