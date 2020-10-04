package services

import akka.actor.{Actor, Props}
import com.typesafe.config.{Config, ConfigFactory}
import play.api.libs.mailer._

object MyComponent {
  def props: Props = {
    Props(new MyComponent)
  }
}

class MyComponent extends Actor with MailerComponents {

  override def receive: Receive = {
    case "data" => mailerClient.send(MailerService.sendEmail)
    case _ => print("Email address is wrong")
  }

  override def config: Config = ConfigFactory.load()
}
