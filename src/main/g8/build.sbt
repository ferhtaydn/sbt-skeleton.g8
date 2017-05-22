import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

name := "$name$"

organization := "$organization$"

version := "$version$"

scalaVersion := "2.12.0"

crossScalaVersions := Seq("2.11.8", "2.12.0")

resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= {

  // val akkaVersion = "2.5.1"
  // val akkaHttpVersion = "10.0.6"
  Seq(

    //"com.chuusai" %% "shapeless" % "2.3.2",
    //"org.typelevel" %% "cats" % "0.9.0",

    //"com.typesafe.akka" %% "akka-actor" % akkaVersion,
    //"com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    //"com.typesafe.akka" %% "akka-stream" % akkaVersion,
    //"com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion,
    //"com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",

    //"com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    //"com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    //"com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    //"com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,

    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
  )
}

scalacOptions ++= Seq(
    "-target:jvm-1.8",
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:experimental.macros",
    "-unchecked",
    //"-Ywarn-unused-import",
    "-Ywarn-nullary-unit",
    "-Xfatal-warnings",
    "-Xlint",
    //"-Yinline-warnings",
    "-Ywarn-dead-code",
    "-Xfuture")

initialCommands := "import $organization$.$name;format="lower,word"$._"

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(RewriteArrowSymbols, true)
