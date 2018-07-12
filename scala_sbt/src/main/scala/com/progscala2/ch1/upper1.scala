package com.progscala2.ch1

object Uppoer {

  def main(args: Array[String]): Unit = {
    val output = args.map(_.toUpperCase()).mkString(" ")
    println(output)
  }
}
