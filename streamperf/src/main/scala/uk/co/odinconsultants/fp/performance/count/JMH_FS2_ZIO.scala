package uk.co.odinconsultants.fp.performance.count

import java.util.concurrent.TimeUnit
import zio.ZIO
import zio.stream._

import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}

class JMH_FS2_ZIO {
  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  def measureThroughput(): Unit =  {
    val s: Stream[Nothing, Int] = Stream.fromIterable(Data.list)
    val c: ZIO[Any, Nothing, Int] = s.fold(0)((acc, _) => acc + 1)
    val task = c.flatMap { count =>
      if (count != Data.N) {
        ZIO.fail(new Exception(s"$count != ${Data.N}"))
      } else {
        ZIO.unit
      }
    }
    task.run
    ()
  }
}
