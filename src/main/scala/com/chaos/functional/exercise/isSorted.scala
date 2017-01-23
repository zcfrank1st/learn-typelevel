package com.chaos.functional.exercise

/**
  * Created by zcfrank1st on 23/01/2017.
  */
object isSorted extends App {
  def isSorted[A] (as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    as.sameElements(as.sortWith(ordered))
  }

  def smaller (a: Int, b: Int): Boolean = {
    a < b
  }

  println(isSorted(Array(1, 2, 4, 5, 7), smaller))

  println(isSorted(Array(1, 2, 4, 5, 0), smaller))

  println(isSorted(Array(1, 2, 4, 5, 0), (x: Int, y: Int) => x < y))
}
