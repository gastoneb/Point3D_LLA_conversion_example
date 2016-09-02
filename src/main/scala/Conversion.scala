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

  def point3DtoLLA(point:Vector3D):GeodeticPoint = {
    val absDate = new AbsoluteDate(new AbsoluteDate(),unixTimeStamp.toDouble/1000.0)
    val source = VesselInfoHelper.getSource(msg).get

    // Look up the TLE corresponding to Noon on the calendar day the message was recorded
    val tleStringArray = TleStore.getDailyTle(source, unixTimeStamp).split("/n")
    val tle = new TLE(tleStringArray(0), tleStringArray(1))

    // Create a propagator
    val propagator = TLEPropagator.selectExtrapolator(tle)
    val frame = propagator.getFrame()

    // Propagate the TLE and extract the satellite coordinates
    val ecefPoint = propagator.getPVCoordinates(absDate).getPosition()
    val llaPoint = geoid.transform(point, frame, absDate)

  }
}
