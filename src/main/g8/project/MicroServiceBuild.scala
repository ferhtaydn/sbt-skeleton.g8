
import sbt._
import play.sbt.PlayImport._
import play.core.PlayVersion
import uk.gov.hmrc.SbtAutoBuildPlugin
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin
import uk.gov.hmrc.versioning.SbtGitVersioning

object MicroServiceBuild extends Build with MicroService {

  val appName = "$!APP_NAME!$"

  override lazy val appDependencies: Seq[ModuleID] = compile ++ test()

  val compile = Seq(
    <!--(if MONGO)-->
    "uk.gov.hmrc" %% "play-reactivemongo" % "$!playReactivemongoVersion!$",
    <!--(end)-->
    ws,
    "com.typesafe.play" %% "play" % PlayVersion.current,
  "uk.gov.hmrc" %% "microservice-bootstrap" % "$!microserviceBootstrapVersion!$",
  "uk.gov.hmrc" %% "play-authorisation" % "$!playAuthVersion!$",
  "uk.gov.hmrc" %% "play-url-binders" % "$!playUrlBindersVersion!$",
  "uk.gov.hmrc" %% "play-config" % "$!playConfigVersion!$",
  "uk.gov.hmrc" %% "logback-json-logger" % "$!logbackJsonLoggerVersion!$",
  "uk.gov.hmrc" %% "domain" % "$!domainVersion!$"
  )

  def test(scope: String = "test,it") = Seq(
    "uk.gov.hmrc" %% "hmrctest" % "$!hmrcTestVersion!$" % scope,
    "org.scalatest" %% "scalatest" % "2.2.6" % scope,
    "org.pegdown" % "pegdown" % "1.6.0" % scope,
    "com.typesafe.play" %% "play-test" % PlayVersion.current % scope
  )

}
