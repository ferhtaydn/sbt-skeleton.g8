
import sbt._
import play.sbt.PlayImport._
import play.core.PlayVersion


object StubServiceBuild extends Build with MicroService {
  import scala.util.Properties.envOrElse

  val appName = "$!APP_NAME!$"
  val appVersion = envOrElse("$!UPPER_CASE_APP_NAME_UNDERSCORE_ONLY!$_VERSION", "999-SNAPSHOT")

  override lazy val appDependencies: Seq[ModuleID] = compile ++ test()

  val compile = Seq(
    "com.typesafe.play" %% "play" % PlayVersion.current,
    ws,
    "uk.gov.hmrc" %% "microservice-bootstrap" % "$!microserviceBootstrapVersion!$",
    "uk.gov.hmrc" %% "play-config" % "$!playConfigVersion!$",
    "uk.gov.hmrc" %% "logback-json-logger" % "$!logbackJsonLoggerVersion!$"
  )

  def test(scope: String = "test") = Seq(
    "uk.gov.hmrc" %% "hmrctest" % "$!hmrcTestVersion!$" % scope,
    "org.scalatest" %% "scalatest" % "2.2.6" % scope,
    "org.pegdown" % "pegdown" % "1.6.0" % scope,
    "com.typesafe.play" %% "play-test" % PlayVersion.current % scope
  )

}
