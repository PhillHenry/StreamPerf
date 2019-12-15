package uk.co.odinconsultants.fp.performance.count

import java.util.concurrent.TimeUnit

import monix.eval.Task
import monix.execution.Scheduler
import monix.reactive.Observable
import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Mode, OutputTimeUnit}

class JMH_Monix_Count {

  @Benchmark
  @BenchmarkMode(Array(Mode.Throughput))
  @OutputTimeUnit(TimeUnit.SECONDS)
  def measureThroughput(): Unit =  {
    implicit val scheduler: Scheduler = monix.execution.Scheduler.Implicits.global
    import scala.concurrent.duration._
    val stream = Observable.fromIterable(Data.list)
    val count = stream.foldLeftL(0)((acc, _) => acc + 1)
    val task = count.flatMap(c => Assertions.checkCount[Task](c))
    task.runSyncUnsafe(1.minute)
  }
}
