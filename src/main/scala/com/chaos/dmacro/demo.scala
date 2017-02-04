package com.chaos.dmacro

import scala.reflect.macros.whitebox
import scala.language.experimental.macros

/**
  * Created by zcfrank1st on 04/02/2017.
  */

object M {
  def printf(format: String, params: Any*): Unit = macro impl

  def impl(c: whitebox.Context)(format: c.Expr[String], params: c.Expr[Any]*): c.Expr[Unit] = {
    import c.universe._
    reify {
      println("hello world")
    }
  }
}