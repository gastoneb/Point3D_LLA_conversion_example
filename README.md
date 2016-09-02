# Vector3D_LLA_conversion_example

A point on or around the earth's surface can be expressed in terms of latitude, longitude and altitude/height above sea level (the geoid). The same point can also be expressed as a cartesian vector based on a common reference frame. Conversion between the two coordinate systems is non-trivial because a) the Earth is not a sphere, and b) the Earth's gravitational field is not homogeneous.

A handful of java segments can be found online for converting between the two coordinate systems using java. However, none of these use established libraries, which may be desireable for some applications. 

Orekit, a java library for orbital dynamics, provides the ability to convert between lla and ecef (actually the newer itrf). However, this library is not exactly easy to dive into if you just want to use it for basic conversions. I've created this example code to demonstrate the use of the orekit library. 
