import com.typesafe.sbt.web.Import.WebKeys

scalaVersion in ThisBuild := "2.12.4"

scalafmtOnCompile in ThisBuild := true

lazy val commonSettings = Seq(
  organization := "ba.sake",
  version := "0.0.0-SNAPSHOT",
  libraryDependencies ++= Seq(
    "com.lihaoyi" %% "scalatags" % "0.6.7",
    "org.webjars" % "anchorjs"   % "3.2.2"
  )
)

lazy val commonSiteSettings = Seq(
  (hepek in Compile) := {
    WebKeys.assets.value // run 'assets' task also after compiling... :)
    (hepek in Compile).value
  },
  libraryDependencies ++= Seq(
    "org.webjars" % "jquery"            % "3.2.1",
    "org.webjars" % "bootswatch-cyborg" % "3.3.7"
  ),
  // override for easier relative referencing, default is "lib"
  WebKeys.webModulesLib := "site/lib"

  // enable this to see more verbose output
  //, logLevel in hepek := Level.Debug
) ++ commonSettings

/* PROJECTS-MODULES */
lazy val core = (project in file("core"))
  .settings(commonSettings)
  .enablePlugins(HepekPlugin)

lazy val sakeBa = (project in file("sake-ba"))
  .settings(commonSiteSettings)
  .dependsOn(core)
  .enablePlugins(HepekPlugin, SbtWeb)

lazy val sakeBaBlog = (project in file("sake-ba-blog"))
  .settings(
    commonSiteSettings,
    libraryDependencies ++= Seq(
      "org.webjars" % "prismjs" % "1.6.0" // code highlight
    )
  )
  .dependsOn(core)
  .enablePlugins(HepekPlugin, SbtWeb)
