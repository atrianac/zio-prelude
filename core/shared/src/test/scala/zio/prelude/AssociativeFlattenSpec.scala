package zio.prelude

import zio.test._
import zio.test.laws._

object AssociativeFlattenSpec extends DefaultRunnableSpec {

  def spec: ZSpec[Environment, Failure] =
    suite("AssociativeFlattenSpec")(
      suite("laws")(
        testM("chunk")(checkAllLaws(AssociativeFlatten)(GenF.chunk, Gen.chunkOf(Gen.anyInt))),
        testM("either")(checkAllLaws(AssociativeFlatten)(GenFs.either(Gen.anyInt), Gen.anyInt)),
        testM("option")(checkAllLaws(AssociativeFlatten)(GenF.option, Gen.anyInt)),
        testM("list")(checkAllLaws(AssociativeFlatten)(GenF.list, Gen.anyInt)),
        testM("vector")(checkAllLaws(AssociativeFlatten)(GenF.vector, Gen.anyInt)),
        testM("map")(checkAllLaws(AssociativeFlatten)(GenFs.map(Gen.anyInt), Gen.anyInt))
      )
    )
}
