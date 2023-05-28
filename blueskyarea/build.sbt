name := "blueskyarea"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.typesafe.slick" %% "slick" % "1.0.1",
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "joda-time" % "joda-time" % "2.3"
)     

play.Project.playScalaSettings
