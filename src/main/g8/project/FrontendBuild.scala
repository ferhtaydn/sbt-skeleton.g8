
import sbt._
import play.sbt.PlayImport._
import play.core.PlayVersion
import uk.gov.hmrc.SbtAutoBuildPlugin
import uk.gov.hmrc.sbtdistributables.SbtDistributablesPlugin
import uk.gov.hmrc.versioning.SbtGitVersioning

object FrontendBuild extends Build with MicroService {

  val appName = "$!APP_NAME!$"

  override lazy val appDependencies: Seq[ModuleID] = compile ++ test()

  val compile = Seq(
    ws,
    "com.typesafe.play" %% "play" % PlayVersion.current,
    "uk.gov.hmrc" %% "frontend-bootstrap" % "$!frontendBootstrapVersion!$",
    "uk.gov.hmrc" %% "play-partials" % "$!playPartialsVersion!$",
    "uk.gov.hmrc" %% "play-authorised-frontend" % "$!playAuthorisedFrontendVersion!$",
    "uk.gov.hmrc" %% "play-config" % "$!playConfigVersion!$",
    "uk.gov.hmrc" %% "logback-json-logger" % "$!logbackJsonLoggerVersion!$",
    "uk.gov.hmrc" %% "govuk-template" % "$!govukTemplateVersion!$",
    "uk.gov.hmrc" %% "play-ui" % "$!playUiVersion!$"
  )

  def test(scope: String = "test") = Seq(
    "uk.gov.hmrc" %% "hmrctest" % "$!hmrcTestVersion!$" % scope,
    "org.scalatest" %% "scalatest" % "2.2.6" % scope,
    "org.pegdown" % "pegdown" % "1.6.0" % scope,
    "org.jsoup" % "jsoup" % "1.8.1" % scope,
    "com.typesafe.play" %% "play-test" % PlayVersion.current % scope
  )

}
