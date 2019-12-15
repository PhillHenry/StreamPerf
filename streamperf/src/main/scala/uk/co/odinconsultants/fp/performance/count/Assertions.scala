package uk.co.odinconsultants.fp.performance.count

import cats.effect.Sync

object Assertions {

  def checkCount[F[_]](count: Int)(implicit F: Sync[F]): F[Unit] = if (count != Data.N)
    F.raiseError(new Throwable("" + count))
  else F.unit

}
