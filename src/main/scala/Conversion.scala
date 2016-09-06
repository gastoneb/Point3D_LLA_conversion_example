package conversion

import org.orekit.time.{AbsoluteDate,TimeScalesFactory}
import org.orekit.models.earth.{Geoid, ReferenceEllipsoid}
import org.orekit.utils.Constants
import org.orekit.utils.IERSConventions
import org.orekit.frames.FramesFactory
import org.orekit.forces.gravity.potential.GravityFieldFactory
import org.orekit.bodies.GeodeticPoint
import org.orekit.data.{DataProvidersManager,DirectoryCrawler}
import java.io.File
import org.hipparchus.geometry.euclidean.threed.Vector3D


object ConversionTools {
// Load configuration data
  val orekitData = new File("./data/orekit-data")
  val manager = DataProvidersManager.getInstance()
  manager.addProvider(new DirectoryCrawler(orekitData))

// Create geoid
  val itrf = FramesFactory.getITRF(IERSConventions.IERS_2010, true)
  val referenceEllipsoid = ReferenceEllipsoid.getWgs84(itrf)
  val gravity = GravityFieldFactory.getConstantNormalizedProvider(2,2) 
  //The above parameters are (degree,order). Arbitrary for now.
  val geoid = new Geoid(gravity, referenceEllipsoid)

  def cartesianToGeodetic(cartesianPoint:Vector3D):GeodeticPoint = {
    val geodeticPoint = geoid.transform(cartesianPoint, itrf, new AbsoluteDate())
    geodeticPoint
  }
  
  def geodeticToCartesian(geodeticPoint:GeodeticPoint):Vector3D = {
    val vector3DPoint = geoid.transform(geodeticPoint)
    vector3DPoint
  }
}
