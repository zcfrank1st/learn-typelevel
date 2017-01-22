package com.chaos.cats.demo

/**
  * Created by zcfrank1st on 22/01/2017.
  */

/**
  * trait Semigroup[A] {
  *   def combine(x: A, y: A): A
  * }
  *
  */

class SemigroupDemo {

}

object SemigroupDemo {
  def main(args: Array[String]): Unit = {
    import cats.Semigroup

    implicit val intAdditionSemigroup: Semigroup[Int] = new Semigroup[Int] {
      override def combine(x: Int, y: Int): Int = x + y
    }

    println(Semigroup[Int].combine(1, 2))

    import cats.instances.all._
    import cats.syntax.semigroup._

    val map1 = Map("hello" -> 0, "world" -> 1)
    val map2 = Map("hello" -> 2, "world" -> 3)

    println(map1 |+| map2)
  }
}