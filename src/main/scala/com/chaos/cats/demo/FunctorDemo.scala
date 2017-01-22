package com.chaos.cats.demo

import cats.Functor

/**
  * Created by zcfrank1st on 22/01/2017.
  */

/**
  * trait Functor[F[_]] {
  *   def map[A, B](fa: F[A])(f: A => B): F[B]
  *
  *   def lift[A, B](f: A => B): F[A] => F[B] = fa => map(fa)(f)
  * }
  *
  */

class FunctorDemo {

}

object FunctorDemo {
  def main(args: Array[String]): Unit = {
    implicit val functorForOption: Functor[Option] = new Functor[Option] {
      override def map[A, B](fa: Option[A])(f: (A) => B) = fa match {
        case None => None
        case Some(a) => Some(f(a))
      }


    }
  }
}
