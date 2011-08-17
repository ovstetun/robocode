name := "RoboCode"

version := "1.0-SNAPSHOT"

organization := "no.mesan.tmo"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.5" % "test" withSources()
)

scalaVersion := "2.9.0-1"
