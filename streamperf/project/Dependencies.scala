import sbt._

object Dependencies {

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  val scala_library = "org.scala-lang" % "scala-library" % "${scala.version}"
  val junit = "junit" % "junit" % "4.11" % "test"
  val scalatest = "org.scalatest" % "scalatest_2.13" % "3.0.3" % "test"
  val scalaz_core = "org.scalaz" % "scalaz-core_2.13" % "7.2.14"
  val scalaz_effect = "org.scalaz" % "scalaz-effect_2.13" % "7.2.14"
  val scalaz_zio = "org.scalaz" % "scalaz-zio_2.13" % "0.5.3"
  val cats_laws = "org.typelevel" % "cats-laws_2.13" % "2.0.1"
  val cats_effect_laws = "org.typelevel" % "cats-effect-laws_2.13" % "2.0.1"
  val cats_testkit = "org.typelevel" % "cats-testkit_2.13" % "2.0.1"
  val cats_free = "org.typelevel" % "cats-free_2.13" % "2.0.1"
  val cats_core = "org.typelevel" % "cats-core_2.13" % "2.0.1"
  val cats_effect = "org.typelevel" % "cats-effect_2.13" % "2.0.1"
  val fs2_core = "co.fs2" % "fs2-core_2.13" % "2.3.0"
  val fs2_io = "co.fs2" % "fs2-io_2.13" % "2.3.0"
  val shapeless_2_12 = "com.chuusai" % "shapeless_2.12" % "2.3.3"
  val fs2_kafka = "com.ovoenergy" % "fs2-kafka_2.13" % "0.20.1"
  val embedded_kafka = "io.github.embeddedkafka" % "embedded-kafka_2.13" % "2.3.0"
  val kafka = "org.apache.kafka" % "kafka_2.13" % "2.3.0"
  val monix = "io.monix" % "monix_2.13" % "3.1.0"
  val jmh = "org.openjdk.jmh" % "jmh-core" % "1.22"

}
