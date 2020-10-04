package controllers

import akka.actor.ActorSystem
import javax.inject._
import play.api.mvc._
import services.MyComponent

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val system = ActorSystem("Mailer")
  val mailer = system.actorOf(MyComponent.props, "mailer")

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    mailer ! "data"
    Ok("Mail send")
  }
}
