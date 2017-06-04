lazy val root = (project in file(".")).
  settings(
    resolvers ++= Seq(
      Resolver.typesafeIvyRepo("releases"),
      Resolver.typesafeIvyRepo("snapshots")
    )
  )