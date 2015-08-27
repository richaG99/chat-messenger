package utils
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
/**
 * Created by richa on 22/08/15.
 */

object DateTimeMapper {

  def dateToStringWithTime(date: DateTime): String = {
    if (date == new DateTime(-1)) {
      ""
    }
    else {
      val dtfOut: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
      dtfOut.print(date)
    }
  }

}