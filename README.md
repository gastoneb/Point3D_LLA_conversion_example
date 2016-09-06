# Vector3D_LLA_conversion_example

A point on or around the earth's surface can be expressed in terms of latitude, longitude and altitude/height above sea level (usually the geoid). The same point can also be expressed as a cartesian vector based on a fixed reference frame. Conversion between the two coordinate systems is non-trivial because a) the Earth is not a sphere, and b) the Earth's gravitational field is not homogeneous.

A handful of java segments can be found online for converting between the two coordinate systems using java. However, none of these use established libraries, which might be desireable for some applications. 

Orekit, a java library for orbital dynamics, provides the ability to convert between the cartesian and geodetic coordinate systems. However, this library can be difficult to dive into if you just want to use it for basic conversions. I've created this example code to demonstrate the use of the orekit library. 

## Instructions
* Clone the repo
* Download and unzip [the orekit configuration data](https://www.orekit.org/forge/attachments/download/610/orekit-data.zip) in the ./data directory. The example code will look here for some reference information. 
* Build the example program with "sbt assembly"
* Run the example program with "sbt run"
