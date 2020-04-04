package uk.co.odinconsultants.fp.performance.count

import java.util.concurrent.TimeUnit

import cats.effect.IO
import fs2.Stream
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}
import uk.co.odinconsultants.fp.performance.count.Assertions.checkCount
import uk.co.odinconsultants.fp.performance.count.Data._

/**
 * Run with something like:
 *  sbt jmh:run Bench -prof jmh.extras.JFR:help
 * FS2 2.0.1
[info]   19.766 ±(99.9%) 0.176 ops/s [Average]
[info]   (min, avg, max) = (19.152, 19.766, 20.058), stdev = 0.235
[info]   CI (99.9%): [19.590, 19.942] (assumes normal distribution)
 * FS2 2.3.0
[info]   19.697 ±(99.9%) 0.510 ops/s [Average]
[info]   (min, avg, max) = (17.061, 19.697, 20.164), stdev = 0.681
[info]   CI (99.9%): [19.187, 20.206] (assumes normal distribution)
 */
class JMH_FS2_Count {

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  def measureThroughput(): Unit =  {
    val io = for {
      stream  <- IO.delay { Stream.emits(list).covary[IO] }
      count   <- stream.chunkLimit(4096 * 256).compile.fold(0) { (acc, b) => acc + b.size }
      _       <- checkCount[IO](count)
    } yield ()

    io.unsafeRunSync()
  }


}
