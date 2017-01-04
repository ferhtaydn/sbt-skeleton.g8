package uk.gov.hmrc.$name$.controllers

import uk.gov.hmrc.play.frontend.controller.FrontendController
import play.api.mvc._
import scala.concurrent.Future
import play.api.Play.current
import play.api.i18n.Messages.Implicits._


object HelloWorld extends HelloWorld

trait HelloWorld extends FrontendController {
  val helloWorld = Action.async { implicit request =>
		Future.successful(Ok(uk.gov.hmrc.$name$.views.html.helloworld.hello_world()))
  }
}
