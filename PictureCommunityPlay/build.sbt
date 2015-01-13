name := """PictureCommunityPlay"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
 "commons-io" % "commons-io" % "2.3",
 javaJdbc,
 javaEbean,
 cache
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)
