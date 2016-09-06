package example
import conversion.ConversionTools
import org.orekit.bodies.GeodeticPoint

object Example{
  def main(args:Array[String]): Unit = {

    // Create an arbitrary point from lat/lon/alt and convert it to a cartesian point
    val geoPoint = new GeodeticPoint(43.4723,80.5449,329)
    val convertedGeoPoint = ConversionTools.geodeticToCartesian(geoPoint)
    println("Geodetic point to cartesian point:")
    println(geoPoint)
    println(convertedGeoPoint)

  }  
}
