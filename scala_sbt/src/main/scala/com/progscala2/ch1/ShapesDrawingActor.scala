package com.progscala2.ch1

object Messages {
  object Exit
  object Finished
  case class Response(message: String)
}

import akka.actor.Actor

class ShapesDrawingActor extends Actor {
  import Messages._

  def receive = {
    case s: Shape =>
      s.draw(str => println(s"ShapesDrawingActor: $str"))
      sender ! Response(s"ShapesDrawingActor: $s drawn")
    case Exit =>
      println(s"ShapesDrawingActor: exiting...")
      sender ! Finished
    case unexpected =>
      val response = Response(s"ERROR: Unknow message: $unexpected")
      println(s"ShapeDrawingActor: $response")
      sender ! response
  }

}
