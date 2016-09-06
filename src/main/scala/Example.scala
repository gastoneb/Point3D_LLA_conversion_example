package example
import conversion.ConversionTools
import org.orekit.bodies.GeodeticPoint
import org.hipparchus.geometry.euclidean.threed.Vector3D
import scala.math.toRadians

object Example{
  def main(args:Array[String]): Unit = {

    // Create an arbitrary point from lat/lon/alt and convert it to a cartesian point
    val geoPoint = new GeodeticPoint(toRadians(43.4723),toRadians(-80.5449),329)
    val convertedGeoPoint = ConversionTools.geodeticToCartesian(geoPoint)
    println("Geodetic point to cartesian point:")
    println(geoPoint)
    println(convertedGeoPoint)
    println("")

    // Create an arbitrary cartesian point and convert it to a geodetic point.
    val cartesianPoint = new Vector3D(1107854,-4345398,4520403)
    val convertedCartesianPoint = ConversionTools.cartesianToGeodetic(cartesianPoint)
    println("Cartesian point to geodetic point:")
    println(cartesianPoint)
    println(convertedCartesianPoint)

  }  
}
