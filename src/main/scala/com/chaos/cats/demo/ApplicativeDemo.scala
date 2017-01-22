package com.chaos.cats.demo

import cats.{Monad, SemigroupK}

/**
  * Created by zcfrank1st on 22/01/2017.
  */

/**
  * trait Applicative[F[_]] extends Functor[F] {
  *   def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
  *
  *   def pure[A](a: A): F[A]
  *
  *   def map[A, B](fa: F[A])(f: A=> B): F[B] = ap(pure(f))(fa)
  * }
  *
  */

class ApplicativeDemo {

}

object ApplicativeDemo {
  def main(args: Array[String]): Unit = {

  }
}


