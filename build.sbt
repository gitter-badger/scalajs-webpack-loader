lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "scalajs-webpack-loader",
    scalaVersion := "2.13.1",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped"),
    libraryDependencies ++= Seq(
      // Coursier:
      "io.get-coursier" %%% "coursier" % "2.0.0-RC6-10",
      // Typings for NPM dependencies
      "org.scalablytyped" %%% "loader-utils" % "1.1-dt-20180306Z-20260d",
      "org.scalablytyped" %%% "schema-utils" % "2.6.5-3efa30",
      "org.scalablytyped" %%% "webpack" % "4.41-dt-20200209Z-7b3b5d",
      "org.scalablytyped" %%% "fs-extra" % "8.0-dt-20191016Z-4c34ac",
      "org.scalablytyped" %%% "node-fetch" % "2.5-dt-20191126Z-cfa9e9",
      // Test dependencies:
      "org.scalameta" %%% "munit" % "0.7.1" % Test
    ),
    scalaSource in Test := baseDirectory.value / "test" / "unit",
    testFrameworks += new TestFramework("munit.Framework")
  )
