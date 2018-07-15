package com.progscala2.ch1

import akka.actor.{Props, Actor, ActorRef, ActorSystem}
import com.typesafe.config.ConfigFactory

//仅用于本文件的消息
private object Start


object ShapesDrawingDriver {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("DrawingActorSystem", ConfigFactory.load())
    val drawer = system.actorOf(Props(new ShapesDrawingActor), "drawingActor")
    val driver = system.actorOf(Props(new ShapesDrawingDriver(drawer)), "drawingService")
    driver ! Start
  }

}

class ShapesDrawingDriver(drawingActor: ActorRef) extends Actor {
  import Messages._

  def receive = {
    case Start =>
      drawingActor ! Circle(Point(0.0, 0.0), 1.0)
      drawingActor ! Rectangle(Point(0.0, 0.0), 2, 5)
      drawingActor ! 3.14159
      drawingActor ! Triangle(Point(0.0, 0.0), Point(2.0, 0.0), Point(1.0, 2.0))
      drawingActor ! Exit
    case Finished =>
      println(s"ShapesDriver: clean up...")
      context.system.stop(drawingActor)
    case response: Response =>
      println("ShapesDrawingDriver: Response = " + response)
    case unexpected =>
      println("ShapesDrawingDriver: ERROR: Received an unexpected message = " + unexpected)
  }
}
