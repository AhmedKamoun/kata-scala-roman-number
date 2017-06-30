name := "kata-scala"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.mockito" % "mockito-all" % "1.9.5"
)

scalacOptions ++= Seq("-Yrangepos", "-feature", "-unchecked", "-deprecation", "-encoding", "utf8")