package com.chaos.shapeless.demo

/**
  * Created by zcfrank1st on 20/01/2017.
  */
import shapeless._

trait CsvEncoder[A] {
  def encode(value: A): List[String]
}

case class Employee(name: String, number: Int, manager: Boolean)
case class IceCream(name: String, numCherries: Int, inCone: Boolean)

object CsvEncoder {
  def apply[A](implicit enc: CsvEncoder[A]): CsvEncoder[A] = enc

  def createEncoder[A](func: A => List[String]):CsvEncoder[A] = new CsvEncoder[A] {
    override def encode(value: A) = func(value)
  }

  implicit val hnilEncoder: CsvEncoder[HNil] = createEncoder(_ => Nil)

  implicit def hlistEncoder[H, T <: HList] (
                                           implicit
                                           hEncoder: CsvEncoder[H],
                                           tEncoder: CsvEncoder[T]
                                           ): CsvEncoder[H :: T] = createEncoder
  {
    case h :: t =>
      hEncoder.encode(h) ++ tEncoder.encode(t)
  }

  implicit val booleanEncoder: CsvEncoder[Boolean] = createEncoder(b => if (b) List("yes") else List("no"))
  implicit val intEncoder: CsvEncoder[Int] = createEncoder(b => List(b.toString))
  implicit val stringEncoder: CsvEncoder[String] = createEncoder(b => List(b))

  def writeCsv[A] (values: List[A]) (implicit  enc: CsvEncoder[A]): String = values.map(value => enc.encode(value).mkString(",")).mkString("\n")
}

object Demo1 {
  def main(args: Array[String]): Unit = {
    val strings = List("hello" :: "world" :: 1 :: HNil, "hello1" :: "world1" :: 1 :: HNil)

    println(CsvEncoder.writeCsv(strings))

    import com.chaos.dmacro.M

    M.printf("", "")
  }
}