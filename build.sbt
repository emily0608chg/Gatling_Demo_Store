enablePlugins(GatlingPlugin)

scalaVersion := "2.13.8"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

val gatlingVersion = "3.7.3"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.7.3"

libraryDependencies += "io.gatling" % "gatling-test-framework" % "3.7.3"

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.17.1"

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.17.1"
