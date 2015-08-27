package dtos

/**
 * Created by richa on 22/08/15.
 */
import play.api.libs.json.{Format, Json, JsValue}

trait Base {
  def toJson: JsValue
}

case class Meta(host: String, method: String, path: String, uri: String) extends Base {
  override def toJson: JsValue = Json.toJson(this)
}

object Meta {
  implicit val metaFormat: Format[Meta] = Json.format[Meta]
}

case class Response(status: String, status_code: Int, meta: Meta, record_count: Option[Int] = None, data: Option[JsValue] = None, message: String) extends Base {
  override def toJson: JsValue = Json.toJson(this)
}

object Response {
  implicit val responseFormat: Format[Response] = Json.format[Response]
}
