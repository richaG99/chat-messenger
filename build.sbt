import NativePackagerHelper._
import sbt.Keys._

val commonSettings = Seq(
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.1"
)

fork in Test := true

lazy val root = (project in file(".")).enablePlugins(PlayScala).configs(IntegrationTest)
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      jdbc,
      "org.postgresql"              % "postgresql"            % "9.3-1102-jdbc41",
      "com.typesafe.slick"          %% "slick"                % "2.1.0",
      "com.typesafe.play"           %% "play-slick"           % "0.8.1",
      "joda-time"                   % "joda-time"             % "2.7",
      "org.joda"                    % "joda-convert"          % "1.7",
      "com.github.tototoshi"        %% "slick-joda-mapper"    % "1.2.0",
      "com.norbitltd"               % "spoiwo"                % "1.0.6",
      "org.parboiled"               %% "parboiled"            % "2.0.1",
      "org.json4s"                  %% "json4s-jackson"       % "3.2.11",
      "com.edulify"                 %% "play-hikaricp"        % "1.5.0",
     "com.github.nscala-time"        %% "nscala-time"          % "1.8.0"
         )
  )




