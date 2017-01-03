package uk.gov.hmrc.$!APP_PACKAGE_NAME!$

import play.api._
import play.api.mvc._
import uk.gov.hmrc.play.config.ControllerConfig
import net.ceedubs.ficus.Ficus._
import com.typesafe.config.Config
import uk.gov.hmrc.play.http.logging.filters.LoggingFilter
import uk.gov.hmrc.play.filters.MicroserviceFilterSupport

object ControllerConfiguration extends ControllerConfig {
  lazy val controllerConfigs = Play.current.configuration.underlying.as[Config]("controllers")
}

object MicroserviceLoggingFilter extends LoggingFilter with MicroserviceFilterSupport {
  override def controllerNeedsLogging(controllerName: String) = ControllerConfiguration.paramsForController(controllerName).needsLogging
}

object StubGlobal
  extends GlobalSettings {

  lazy val appName = Play.current.configuration.getString("appName").getOrElse("APP NAME NOT SET")

  override def onStart(app: Application) {
    Logger.info(s"Starting stub : $appName : in mode : ${app.mode}")
    super.onStart(app)
  }

  override def doFilter(a: EssentialAction): EssentialAction = {
    Filters(super.doFilter(a), MicroserviceLoggingFilter)
  }

}
