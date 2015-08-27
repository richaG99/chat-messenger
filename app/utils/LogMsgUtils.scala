package utils

/**
 * Created by richa on 22/08/15.
 */
object LogMsgUtils {

  def dbTimeLogMsgMS(duration:Long,source:String="")=s"${source}: Database response time is ${duration} ms"
}
