package uk.co.odinconsultants.fp.performance.count

import java.util.concurrent.TimeUnit

import cats.effect.{IO, Sync}
import fs2.Stream
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}
import uk.co.odinconsultants.fp.performance.count.Data._

/**
 * Run with something like:
 *  sbt jmh:run Bench -prof jmh.extras.JFR:help
 */
class JMH_FS2_Count {

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  def measureThroughput(): Unit =  {
    val io = for {
      stream  <- IO.delay { Stream.emits(list).covary[IO] }
      count   <- stream.chunkLimit(4096 * 256).compile.fold(0) { (acc, b) => acc + b.size }
      _       <- printCount[IO](count)
    } yield ()

    io.unsafeRunSync()
  }


  def printCount[F[_]](count: Int)(implicit F: Sync[F]): F[Unit] = if (count != N)
    F.raiseError(new Throwable("" + count))
  else F.unit

}
