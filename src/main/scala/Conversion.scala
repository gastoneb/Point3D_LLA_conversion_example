package conversion

import org.orekit.time.{AbsoluteDate,TimeScalesFactory}
import org.orekit.models.earth.{Geoid, ReferenceEllipsoid}
import org.orekit.utils.Constants
import org.orekit.utils.IERSConventions
import org.orekit.frames.FramesFactory
import org.orekit.forces.gravity.potential.GravityFieldFactory
import org.orekit.bodies.GeodeticPoint

import org.hipparchus.geometry.euclidean.threed.Vector3D

object ConversionTools {

  val itrf = FramesFactory.getITRF(IERSConventions.IERS_2010, true)
  val referenceEllipsoid = ReferenceEllipsoid.getWgs84(itrf)
  val gravity = GravityFieldFactory.getConstantNormalizedProvider(2,2) //The parameters are (degree,order). Arbitrary for now.
  val geoid = new Geoid(gravity, referenceEllipsoid)

  def CartesianToGeodetic(cartesianPoint:Vector3D):GeodeticPoint = {
    val geodeticPoint = geoid.transform(cartesianPoint, itrf, new AbsoluteDate())
    geodeticPoint
  }
}
