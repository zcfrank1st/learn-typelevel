//package com.chaos.shapeless.demo
//
///**
//  * Created by zcfrank1st on 20/01/2017.
//  */
//import shapeless._
//
//trait CsvEncoder[A] {
//  def encode(value: A): List[String]
//}
//
//case class Employee(name: String, number: Int, manager: Boolean)
//case class IceCream(name: String, numCherries: Int, inCone: Boolean)
//
//object CsvEncoder {
//  def apply[A](implicit enc: CsvEncoder[A]): CsvEncoder[A] = enc
//
//  def instance[A](func: A => List[String]):CsvEncoder[A] = new CsvEncoder[A] {
//    override def encode(value: A) = func(value)
//  }
//
//  implicit val booleanEncoder: CsvEncoder[Boolean] = instance(b => if (b) List("yes") else List("no"))
//
//  implicit val employeeEncoder: CsvEncoder[Employee] = new CsvEncoder[Employee] {
//    override def encode(value: Employee) = List (
//      value.name,
//      value.number.toString,
//      if (value.manager) "yes" else "no"
//    )
//  }
//
//  implicit val iceCreamEncoder: CsvEncoder[IceCream] = new CsvEncoder[IceCream] {
//    override def encode(value: IceCream) = List (
//      value.name,
//      value.numCherries.toString,
//      if (value.inCone) "yes" else "no"
//    )
//  }
//
//  implicit def pairEncoder[A, B](
//                                  implicit
//                                  aEncoder: CsvEncoder[A],
//                                  bEncoder: CsvEncoder[B]
//                                ):CsvEncoder[(A, B)] = new CsvEncoder[(A, B)] {
//    override def encode(value: (A, B)) = {
//      val (a, b) = value
//      aEncoder.encode(a) ++ bEncoder.encode(b)
//    }
//  }
//
//  def writeCsv[A] (values: List[A]) (implicit  enc: CsvEncoder[A]): String = values.map(value => enc.encode(value).mkString(",")).mkString("\n")
//}
//
//object Demo {
//  def main(args: Array[String]): Unit = {
//    val employees: List[Employee] = List(
//      Employee("Bill", 1, true),
//      Employee("Peter", 2, false),
//      Employee("Milton", 3, false)
//    )
//
//    println(CsvEncoder.writeCsv(employees))
//    println(CsvEncoder.writeCsv(employees zip employees))
//  }
//}