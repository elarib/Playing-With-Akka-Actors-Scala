package hello

import akka.actor.{Props, ActorSystem, Actor}
import akka.event.Logging

/**
  * Created by elarib on 3/31/16.
  */
class MyActor extends Actor {
  val log = Logging(context.system, this)
  def receive = {
    case "test" ⇒ log.info("received test")
    case _      ⇒ log.info("received unknown message")
  }
}


object Main extends App {
  val system = ActorSystem("MySystem")
  val myActor = system.actorOf(Props[MyActor], name = "myactor")

  myActor ! "test"
  myActor ! "Blabla"
}
