name := "diabetic-assist"

import android.Keys._
androidBuild

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
scalaVersion := "2.11.7"
scalacOptions in Compile += "-feature"

updateCheck in Android := {} // disable update check
proguardCache in Android ++= Seq("org.scaloid")

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-keepattributes Signature", "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**" // required from Scala 2.11.4
  , "-dontwarn org.scaloid.**" // this can be omitted if current Android Build target is android-16
)

libraryDependencies ++= Seq(
  "org.scaloid" %% "scaloid" % "4.2"
  /*,
  "com.softwaremill.macwire" %% "macros" % "2.2.3" % "provided",
  "com.softwaremill.macwire" %% "util" % "2.2.3",
  "com.softwaremill.macwire" %% "proxy" % "2.2.3",
  "org.scalactic" %% "scalactic" % "3.0.0-RC2",
  "org.scalatest" %% "scalatest" % "3.0.0-RC2" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test",
  "org.scalaz" %% "scalaz-core" % "7.2.4" */
)

run <<= run in Android
install <<= install in Android

// without this, @Config throws an exception,
unmanagedClasspath in Test ++= (bootClasspath in Android).value

//protifySettings
