
resolvers += Resolver.url("hmrc-sbt-plugin-releases", url("https://dl.bintray.com/hmrc/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe repository mvn" at "http://repo.typesafe.com/typesafe/maven-releases/"

addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "$!sbt_auto_build!$")

addSbtPlugin("uk.gov.hmrc" % "sbt-git-versioning" % "$!sbt_git_versioning!$")

addSbtPlugin("uk.gov.hmrc" % "sbt-distributables" % "$!sbt_distributables!$")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.8")
