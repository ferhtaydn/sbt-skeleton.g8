import sbt._

object PluginDef extends Build {
  lazy val root = Project("plugins", file(".")).dependsOn(g8plugin)
  lazy val g8plugin = ProjectRef(uri("git://github.com/foundweekends/giter8#0.6.9"), "giter8-plugin")
}
