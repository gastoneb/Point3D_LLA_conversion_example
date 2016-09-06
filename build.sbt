name := "Point3D_LLA_conversion_example"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies +=  "org.hipparchus"   %  "hipparchus-geometry" % "1.0"
libraryDependencies += "org.orekit"       %  "orekit"              % "8.0"

mainClass in Compile := Some("example.Example")
