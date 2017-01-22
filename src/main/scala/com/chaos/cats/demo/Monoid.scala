package com.chaos.cats.demo

/**
  * Created by zcfrank1st on 22/01/2017.
  */

/**
  * trait Monoid[A] extends Semigroup[A] {
  *   def empty: A
  * }
  *
  */

class MonoidDemo {

}

object MonoidDemo {
  def main(args: Array[String]): Unit = {
    import cats.Monoid

    implicit val intAdditionMonoid: Monoid[Int] = new Monoid[Int] {
      override def empty: Int = 0

      override def combine(x: Int, y: Int): Int = x + y
    }

    println(Monoid[Int].combine(1, Monoid[Int].empty))

    def combineAll[A: Monoid](as: List[A]): A = as.foldLeft(Monoid[A].empty)(Monoid[A].combine)

    import cats.instances.all._

    assert(6 == combineAll(List(1, 2, 3)), "hello world")



  }
}
