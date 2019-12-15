import sbt._

object Dependencies {

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  val hamcrest_all = "org.hamcrest" % "hamcrest-all" % "1.3" % "test"
  val mockito_all = "org.mockito" % "mockito-all" % "1.10.19" % "test"
  val scala_library = "org.scala-lang" % "scala-library" % "${scala.version}"
  val junit = "junit" % "junit" % "4.11" % "test"
  val scalatest = "org.scalatest" % "scalatest_${scala.compat.version}" % "3.0.3" % "test"
  val scalaz_core = "org.scalaz" % "scalaz-core_${scala.compat.version}" % "${scalaz.version}"
  val scalaz_effect = "org.scalaz" % "scalaz-effect_${scala.compat.version}" % "${scalaz.version}"
  val scalaz_zio = "org.scalaz" % "scalaz-zio_${scala.compat.version}" % "0.5.3"
  val cats_laws = "org.typelevel" % "cats-laws_${scala.compat.version}" % "${cats.version}"
  val cats_effect_laws = "org.typelevel" % "cats-effect-laws_${scala.compat.version}" % "${cats.version}"
  val cats_testkit = "org.typelevel" % "cats-testkit_${scala.compat.version}" % "${cats.version}"
  val cats_free = "org.typelevel" % "cats-free_${scala.compat.version}" % "${cats.version}"
  val cats_core = "org.typelevel" % "cats-core_${scala.compat.version}" % "${cats.version}"
  val cats_effect = "org.typelevel" % "cats-effect_${scala.compat.version}" % "${cats.version}"
  val fs2_core = "co.fs2" % "fs2-core_${scala.compat.version}" % "2.0.1"
  val fs2_io = "co.fs2" % "fs2-io_${scala.compat.version}" % "2.0.1"
  val shapeless_2_12 = "com.chuusai" % "shapeless_2.12" % "2.3.3"
  val fs2_kafka = "com.ovoenergy" % "fs2-kafka_${scala.compat.version}" % "0.20.1"
  val embedded_kafka = "io.github.embeddedkafka" % "embedded-kafka_${scala.compat.version}" % "2.3.0"
  val kafka = "org.apache.kafka" % "kafka_${scala.compat.version}" % "2.3.0"
  val monix = "io.monix" % "monix_${scala.compat.version}" % "3.1.0"
}
