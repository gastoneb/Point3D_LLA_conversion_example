import sbt._
object Dependencies{
  val deps = Seq{
    val hipparchus = "org.hipparchus"   %  "hipparchus-geometry" % "1.0"
    val orekit =     "org.orekit"       %  "orekit"              % "8.0"
  }
}

