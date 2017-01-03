package uk.gov.hmrc.$!APP_PACKAGE_NAME!$.controllers.healthController

import com.typesafe.config.ConfigRenderOptions
import play.api.{Configuration, Play}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

object AdminController extends AdminController{

  import play.api.Play.current

  def manifest = new Manifest(){
    def appName = Play.configuration.getString("appName").getOrElse{
      throw new IllegalArgumentException("no config value for key 'appName'")
    }
  }

}

trait AdminController extends Controller {

  protected def manifest:Manifest

  def ping = Action {
    Ok
  }

  def details() = Action {
    Ok(Json.toJson(manifest.contents))
  }

  def detail(name: String) = Action {
    manifest.contents.get(name) match {
      case Some(m) => Ok(m)
      case None    => NotFound
    }
  }
}
