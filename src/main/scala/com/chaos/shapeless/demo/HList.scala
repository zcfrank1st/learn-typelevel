package com.chaos.shapeless.demo

import shapeless._

/**
  * Created by zcfrank1st on 22/01/2017.
  */
class HListDemo {

}

object addOne extends Poly1 {
  implicit val addOneIntCase: Case.Aux[Int, Int] = at(num => num + 1)
  implicit val addOneStringCase: Case.Aux[String, String] = at(str => str + "1")
}

object Demo2 {
  def main(args: Array[String]): Unit = {
    val demoList = "hello" :: "world" :: 1 :: 2 :: HNil

    println(demoList map addOne)
  }
}
